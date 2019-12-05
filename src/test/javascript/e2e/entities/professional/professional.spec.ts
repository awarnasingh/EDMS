/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { ProfessionalComponentsPage, ProfessionalDeleteDialog, ProfessionalUpdatePage } from './professional.page-object';

const expect = chai.expect;

describe('Professional e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let professionalUpdatePage: ProfessionalUpdatePage;
  let professionalComponentsPage: ProfessionalComponentsPage;
  let professionalDeleteDialog: ProfessionalDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load Professionals', async () => {
    await navBarPage.goToEntity('professional');
    professionalComponentsPage = new ProfessionalComponentsPage();
    await browser.wait(ec.visibilityOf(professionalComponentsPage.title), 5000);
    expect(await professionalComponentsPage.getTitle()).to.eq('Professionals');
  });

  it('should load create Professional page', async () => {
    await professionalComponentsPage.clickOnCreateButton();
    professionalUpdatePage = new ProfessionalUpdatePage();
    expect(await professionalUpdatePage.getPageTitle()).to.eq('Create or edit a Professional');
    await professionalUpdatePage.cancel();
  });

  it('should create and save Professionals', async () => {
    const nbButtonsBeforeCreate = await professionalComponentsPage.countDeleteButtons();

    await professionalComponentsPage.clickOnCreateButton();
    await promise.all([
      professionalUpdatePage.setLocationInput('location'),
      professionalUpdatePage.setTotalExperienceInput('5'),
      professionalUpdatePage.setTitleInput('title'),
      professionalUpdatePage.setTypeOfRoleInput('typeOfRole'),
      professionalUpdatePage.setSkillCategoryInput('skillCategory'),
      professionalUpdatePage.setSpecificSkillsInput('specificSkills'),
      professionalUpdatePage.setGeneralSkillsInput('generalSkills'),
      professionalUpdatePage.setClientDomainInput('clientDomain'),
      professionalUpdatePage.setModeInput('mode'),
      professionalUpdatePage.setEmployerInput('employer'),
      professionalUpdatePage.setPrimeVendorInput('primeVendor'),
      professionalUpdatePage.setEndClientInput('endClient'),
      professionalUpdatePage.setCurrentProjectStartDateInput('2000-12-31'),
      professionalUpdatePage.setCurrentProjectEndDateInput('2000-12-31'),
      professionalUpdatePage.setRemarksInput('remarks'),
      professionalUpdatePage.setCreatedByInput('createdBy'),
      professionalUpdatePage.setCreatedDateInput('2000-12-31'),
      professionalUpdatePage.setUpdatedByInput('updatedBy'),
      professionalUpdatePage.setUpdatedDateInput('2000-12-31'),
      professionalUpdatePage.employeeSelectLastOption()
    ]);
    expect(await professionalUpdatePage.getLocationInput()).to.eq('location', 'Expected Location value to be equals to location');
    expect(await professionalUpdatePage.getTotalExperienceInput()).to.eq('5', 'Expected totalExperience value to be equals to 5');
    expect(await professionalUpdatePage.getTitleInput()).to.eq('title', 'Expected Title value to be equals to title');
    expect(await professionalUpdatePage.getTypeOfRoleInput()).to.eq('typeOfRole', 'Expected TypeOfRole value to be equals to typeOfRole');
    expect(await professionalUpdatePage.getSkillCategoryInput()).to.eq(
      'skillCategory',
      'Expected SkillCategory value to be equals to skillCategory'
    );
    expect(await professionalUpdatePage.getSpecificSkillsInput()).to.eq(
      'specificSkills',
      'Expected SpecificSkills value to be equals to specificSkills'
    );
    expect(await professionalUpdatePage.getGeneralSkillsInput()).to.eq(
      'generalSkills',
      'Expected GeneralSkills value to be equals to generalSkills'
    );
    expect(await professionalUpdatePage.getClientDomainInput()).to.eq(
      'clientDomain',
      'Expected ClientDomain value to be equals to clientDomain'
    );
    expect(await professionalUpdatePage.getModeInput()).to.eq('mode', 'Expected Mode value to be equals to mode');
    expect(await professionalUpdatePage.getEmployerInput()).to.eq('employer', 'Expected Employer value to be equals to employer');
    expect(await professionalUpdatePage.getPrimeVendorInput()).to.eq(
      'primeVendor',
      'Expected PrimeVendor value to be equals to primeVendor'
    );
    expect(await professionalUpdatePage.getEndClientInput()).to.eq('endClient', 'Expected EndClient value to be equals to endClient');
    expect(await professionalUpdatePage.getCurrentProjectStartDateInput()).to.eq(
      '2000-12-31',
      'Expected currentProjectStartDate value to be equals to 2000-12-31'
    );
    expect(await professionalUpdatePage.getCurrentProjectEndDateInput()).to.eq(
      '2000-12-31',
      'Expected currentProjectEndDate value to be equals to 2000-12-31'
    );
    expect(await professionalUpdatePage.getRemarksInput()).to.eq('remarks', 'Expected Remarks value to be equals to remarks');
    expect(await professionalUpdatePage.getCreatedByInput()).to.eq('createdBy', 'Expected CreatedBy value to be equals to createdBy');
    expect(await professionalUpdatePage.getCreatedDateInput()).to.eq('2000-12-31', 'Expected createdDate value to be equals to 2000-12-31');
    expect(await professionalUpdatePage.getUpdatedByInput()).to.eq('updatedBy', 'Expected UpdatedBy value to be equals to updatedBy');
    expect(await professionalUpdatePage.getUpdatedDateInput()).to.eq('2000-12-31', 'Expected updatedDate value to be equals to 2000-12-31');
    await professionalUpdatePage.save();
    expect(await professionalUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await professionalComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last Professional', async () => {
    const nbButtonsBeforeDelete = await professionalComponentsPage.countDeleteButtons();
    await professionalComponentsPage.clickOnLastDeleteButton();

    professionalDeleteDialog = new ProfessionalDeleteDialog();
    expect(await professionalDeleteDialog.getDialogTitle()).to.eq('Are you sure you want to delete this Professional?');
    await professionalDeleteDialog.clickOnConfirmButton();

    expect(await professionalComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
