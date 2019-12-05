import { browser, ExpectedConditions, element, by, ElementFinder } from 'protractor';

export class EmployeeComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-employee div table .btn-danger'));
  title = element.all(by.css('jhi-employee div h2#page-heading span')).first();

  async clickOnCreateButton(timeout?: number) {
    await this.createButton.click();
  }

  async clickOnLastDeleteButton(timeout?: number) {
    await this.deleteButtons.last().click();
  }

  async countDeleteButtons() {
    return this.deleteButtons.count();
  }

  async getTitle() {
    return this.title.getText();
  }
}

export class EmployeeUpdatePage {
  pageTitle = element(by.id('jhi-employee-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));
  empTypeInput = element(by.id('field_empType'));
  srsEmpIdInput = element(by.id('field_srsEmpId'));
  fullNameInput = element(by.id('field_fullName'));
  firstNameInput = element(by.id('field_firstName'));
  lastNameInput = element(by.id('field_lastName'));
  educationInput = element(by.id('field_education'));
  certificationInput = element(by.id('field_certification'));
  emailInput = element(by.id('field_email'));
  contactNoInput = element(by.id('field_contactNo'));
  statusInput = element(by.id('field_status'));
  createdByInput = element(by.id('field_createdBy'));
  createdDateInput = element(by.id('field_createdDate'));
  updatedByInput = element(by.id('field_updatedBy'));
  updatedDateInput = element(by.id('field_updatedDate'));

  async getPageTitle() {
    return this.pageTitle.getText();
  }

  async setEmpTypeInput(empType) {
    await this.empTypeInput.sendKeys(empType);
  }

  async getEmpTypeInput() {
    return await this.empTypeInput.getAttribute('value');
  }

  async setSrsEmpIdInput(srsEmpId) {
    await this.srsEmpIdInput.sendKeys(srsEmpId);
  }

  async getSrsEmpIdInput() {
    return await this.srsEmpIdInput.getAttribute('value');
  }

  async setFullNameInput(fullName) {
    await this.fullNameInput.sendKeys(fullName);
  }

  async getFullNameInput() {
    return await this.fullNameInput.getAttribute('value');
  }

  async setFirstNameInput(firstName) {
    await this.firstNameInput.sendKeys(firstName);
  }

  async getFirstNameInput() {
    return await this.firstNameInput.getAttribute('value');
  }

  async setLastNameInput(lastName) {
    await this.lastNameInput.sendKeys(lastName);
  }

  async getLastNameInput() {
    return await this.lastNameInput.getAttribute('value');
  }

  async setEducationInput(education) {
    await this.educationInput.sendKeys(education);
  }

  async getEducationInput() {
    return await this.educationInput.getAttribute('value');
  }

  async setCertificationInput(certification) {
    await this.certificationInput.sendKeys(certification);
  }

  async getCertificationInput() {
    return await this.certificationInput.getAttribute('value');
  }

  async setEmailInput(email) {
    await this.emailInput.sendKeys(email);
  }

  async getEmailInput() {
    return await this.emailInput.getAttribute('value');
  }

  async setContactNoInput(contactNo) {
    await this.contactNoInput.sendKeys(contactNo);
  }

  async getContactNoInput() {
    return await this.contactNoInput.getAttribute('value');
  }

  async setStatusInput(status) {
    await this.statusInput.sendKeys(status);
  }

  async getStatusInput() {
    return await this.statusInput.getAttribute('value');
  }

  async setCreatedByInput(createdBy) {
    await this.createdByInput.sendKeys(createdBy);
  }

  async getCreatedByInput() {
    return await this.createdByInput.getAttribute('value');
  }

  async setCreatedDateInput(createdDate) {
    await this.createdDateInput.sendKeys(createdDate);
  }

  async getCreatedDateInput() {
    return await this.createdDateInput.getAttribute('value');
  }

  async setUpdatedByInput(updatedBy) {
    await this.updatedByInput.sendKeys(updatedBy);
  }

  async getUpdatedByInput() {
    return await this.updatedByInput.getAttribute('value');
  }

  async setUpdatedDateInput(updatedDate) {
    await this.updatedDateInput.sendKeys(updatedDate);
  }

  async getUpdatedDateInput() {
    return await this.updatedDateInput.getAttribute('value');
  }

  async save(timeout?: number) {
    await this.saveButton.click();
  }

  async cancel(timeout?: number) {
    await this.cancelButton.click();
  }

  getSaveButton(): ElementFinder {
    return this.saveButton;
  }
}

export class EmployeeDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-employee-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-employee'));

  async getDialogTitle() {
    return this.dialogTitle.getText();
  }

  async clickOnConfirmButton(timeout?: number) {
    await this.confirmButton.click();
  }
}
