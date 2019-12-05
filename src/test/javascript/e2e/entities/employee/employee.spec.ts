/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { EmployeeComponentsPage, EmployeeDeleteDialog, EmployeeUpdatePage } from './employee.page-object';

const expect = chai.expect;

describe('Employee e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let employeeUpdatePage: EmployeeUpdatePage;
  let employeeComponentsPage: EmployeeComponentsPage;
  let employeeDeleteDialog: EmployeeDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load Employees', async () => {
    await navBarPage.goToEntity('employee');
    employeeComponentsPage = new EmployeeComponentsPage();
    await browser.wait(ec.visibilityOf(employeeComponentsPage.title), 5000);
    expect(await employeeComponentsPage.getTitle()).to.eq('Employees');
  });

  it('should load create Employee page', async () => {
    await employeeComponentsPage.clickOnCreateButton();
    employeeUpdatePage = new EmployeeUpdatePage();
    expect(await employeeUpdatePage.getPageTitle()).to.eq('Create or edit a Employee');
    await employeeUpdatePage.cancel();
  });

  it('should create and save Employees', async () => {
    const nbButtonsBeforeCreate = await employeeComponentsPage.countDeleteButtons();

    await employeeComponentsPage.clickOnCreateButton();
    await promise.all([
      employeeUpdatePage.setEmpTypeInput('empType'),
      employeeUpdatePage.setSrsEmpIdInput('srsEmpId'),
      employeeUpdatePage.setFullNameInput('fullName'),
      employeeUpdatePage.setFirstNameInput('firstName'),
      employeeUpdatePage.setLastNameInput('lastName'),
      employeeUpdatePage.setEducationInput('education'),
      employeeUpdatePage.setCertificationInput('certification'),
      employeeUpdatePage.setEmailInput('email'),
      employeeUpdatePage.setContactNoInput('contactNo'),
      employeeUpdatePage.setStatusInput('status'),
      employeeUpdatePage.setCreatedByInput('createdBy'),
      employeeUpdatePage.setCreatedDateInput('2000-12-31'),
      employeeUpdatePage.setUpdatedByInput('updatedBy'),
      employeeUpdatePage.setUpdatedDateInput('2000-12-31')
    ]);
    expect(await employeeUpdatePage.getEmpTypeInput()).to.eq('empType', 'Expected EmpType value to be equals to empType');
    expect(await employeeUpdatePage.getSrsEmpIdInput()).to.eq('srsEmpId', 'Expected SrsEmpId value to be equals to srsEmpId');
    expect(await employeeUpdatePage.getFullNameInput()).to.eq('fullName', 'Expected FullName value to be equals to fullName');
    expect(await employeeUpdatePage.getFirstNameInput()).to.eq('firstName', 'Expected FirstName value to be equals to firstName');
    expect(await employeeUpdatePage.getLastNameInput()).to.eq('lastName', 'Expected LastName value to be equals to lastName');
    expect(await employeeUpdatePage.getEducationInput()).to.eq('education', 'Expected Education value to be equals to education');
    expect(await employeeUpdatePage.getCertificationInput()).to.eq(
      'certification',
      'Expected Certification value to be equals to certification'
    );
    expect(await employeeUpdatePage.getEmailInput()).to.eq('email', 'Expected Email value to be equals to email');
    expect(await employeeUpdatePage.getContactNoInput()).to.eq('contactNo', 'Expected ContactNo value to be equals to contactNo');
    expect(await employeeUpdatePage.getStatusInput()).to.eq('status', 'Expected Status value to be equals to status');
    expect(await employeeUpdatePage.getCreatedByInput()).to.eq('createdBy', 'Expected CreatedBy value to be equals to createdBy');
    expect(await employeeUpdatePage.getCreatedDateInput()).to.eq('2000-12-31', 'Expected createdDate value to be equals to 2000-12-31');
    expect(await employeeUpdatePage.getUpdatedByInput()).to.eq('updatedBy', 'Expected UpdatedBy value to be equals to updatedBy');
    expect(await employeeUpdatePage.getUpdatedDateInput()).to.eq('2000-12-31', 'Expected updatedDate value to be equals to 2000-12-31');
    await employeeUpdatePage.save();
    expect(await employeeUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await employeeComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last Employee', async () => {
    const nbButtonsBeforeDelete = await employeeComponentsPage.countDeleteButtons();
    await employeeComponentsPage.clickOnLastDeleteButton();

    employeeDeleteDialog = new EmployeeDeleteDialog();
    expect(await employeeDeleteDialog.getDialogTitle()).to.eq('Are you sure you want to delete this Employee?');
    await employeeDeleteDialog.clickOnConfirmButton();

    expect(await employeeComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
