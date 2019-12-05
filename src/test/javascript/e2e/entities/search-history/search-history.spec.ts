/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { SearchHistoryComponentsPage, SearchHistoryDeleteDialog, SearchHistoryUpdatePage } from './search-history.page-object';

const expect = chai.expect;

describe('SearchHistory e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let searchHistoryUpdatePage: SearchHistoryUpdatePage;
  let searchHistoryComponentsPage: SearchHistoryComponentsPage;
  let searchHistoryDeleteDialog: SearchHistoryDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load SearchHistories', async () => {
    await navBarPage.goToEntity('search-history');
    searchHistoryComponentsPage = new SearchHistoryComponentsPage();
    await browser.wait(ec.visibilityOf(searchHistoryComponentsPage.title), 5000);
    expect(await searchHistoryComponentsPage.getTitle()).to.eq('Search Histories');
  });

  it('should load create SearchHistory page', async () => {
    await searchHistoryComponentsPage.clickOnCreateButton();
    searchHistoryUpdatePage = new SearchHistoryUpdatePage();
    expect(await searchHistoryUpdatePage.getPageTitle()).to.eq('Create or edit a Search History');
    await searchHistoryUpdatePage.cancel();
  });

  it('should create and save SearchHistories', async () => {
    const nbButtonsBeforeCreate = await searchHistoryComponentsPage.countDeleteButtons();

    await searchHistoryComponentsPage.clickOnCreateButton();
    await promise.all([
      searchHistoryUpdatePage.setUserIDInput('userID'),
      searchHistoryUpdatePage.setSearchNameInput('searchName'),
      searchHistoryUpdatePage.setEmpTypeInput('empType'),
      searchHistoryUpdatePage.setDomainInput('domain'),
      searchHistoryUpdatePage.setFromExperienceInput('5'),
      searchHistoryUpdatePage.setToExperienceInput('5'),
      searchHistoryUpdatePage.setLocationInput('location'),
      searchHistoryUpdatePage.setStatusInput('status'),
      searchHistoryUpdatePage.setEndClientInput('endClient'),
      searchHistoryUpdatePage.setSkillsInput('skills'),
      searchHistoryUpdatePage.setEmployeeNameInput('employeeName')
    ]);
    expect(await searchHistoryUpdatePage.getUserIDInput()).to.eq('userID', 'Expected UserID value to be equals to userID');
    expect(await searchHistoryUpdatePage.getSearchNameInput()).to.eq('searchName', 'Expected SearchName value to be equals to searchName');
    expect(await searchHistoryUpdatePage.getEmpTypeInput()).to.eq('empType', 'Expected EmpType value to be equals to empType');
    expect(await searchHistoryUpdatePage.getDomainInput()).to.eq('domain', 'Expected Domain value to be equals to domain');
    expect(await searchHistoryUpdatePage.getFromExperienceInput()).to.eq('5', 'Expected fromExperience value to be equals to 5');
    expect(await searchHistoryUpdatePage.getToExperienceInput()).to.eq('5', 'Expected toExperience value to be equals to 5');
    expect(await searchHistoryUpdatePage.getLocationInput()).to.eq('location', 'Expected Location value to be equals to location');
    expect(await searchHistoryUpdatePage.getStatusInput()).to.eq('status', 'Expected Status value to be equals to status');
    expect(await searchHistoryUpdatePage.getEndClientInput()).to.eq('endClient', 'Expected EndClient value to be equals to endClient');
    expect(await searchHistoryUpdatePage.getSkillsInput()).to.eq('skills', 'Expected Skills value to be equals to skills');
    expect(await searchHistoryUpdatePage.getEmployeeNameInput()).to.eq(
      'employeeName',
      'Expected EmployeeName value to be equals to employeeName'
    );
    await searchHistoryUpdatePage.save();
    expect(await searchHistoryUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await searchHistoryComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last SearchHistory', async () => {
    const nbButtonsBeforeDelete = await searchHistoryComponentsPage.countDeleteButtons();
    await searchHistoryComponentsPage.clickOnLastDeleteButton();

    searchHistoryDeleteDialog = new SearchHistoryDeleteDialog();
    expect(await searchHistoryDeleteDialog.getDialogTitle()).to.eq('Are you sure you want to delete this Search History?');
    await searchHistoryDeleteDialog.clickOnConfirmButton();

    expect(await searchHistoryComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
