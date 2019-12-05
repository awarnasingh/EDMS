import { browser, ExpectedConditions, element, by, ElementFinder } from 'protractor';

export class ProfessionalComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-professional div table .btn-danger'));
  title = element.all(by.css('jhi-professional div h2#page-heading span')).first();

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

export class ProfessionalUpdatePage {
  pageTitle = element(by.id('jhi-professional-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));
  locationInput = element(by.id('field_location'));
  totalExperienceInput = element(by.id('field_totalExperience'));
  titleInput = element(by.id('field_title'));
  typeOfRoleInput = element(by.id('field_typeOfRole'));
  skillCategoryInput = element(by.id('field_skillCategory'));
  specificSkillsInput = element(by.id('field_specificSkills'));
  generalSkillsInput = element(by.id('field_generalSkills'));
  clientDomainInput = element(by.id('field_clientDomain'));
  modeInput = element(by.id('field_mode'));
  employerInput = element(by.id('field_employer'));
  primeVendorInput = element(by.id('field_primeVendor'));
  endClientInput = element(by.id('field_endClient'));
  currentProjectStartDateInput = element(by.id('field_currentProjectStartDate'));
  currentProjectEndDateInput = element(by.id('field_currentProjectEndDate'));
  remarksInput = element(by.id('field_remarks'));
  createdByInput = element(by.id('field_createdBy'));
  createdDateInput = element(by.id('field_createdDate'));
  updatedByInput = element(by.id('field_updatedBy'));
  updatedDateInput = element(by.id('field_updatedDate'));
  employeeSelect = element(by.id('field_employee'));

  async getPageTitle() {
    return this.pageTitle.getText();
  }

  async setLocationInput(location) {
    await this.locationInput.sendKeys(location);
  }

  async getLocationInput() {
    return await this.locationInput.getAttribute('value');
  }

  async setTotalExperienceInput(totalExperience) {
    await this.totalExperienceInput.sendKeys(totalExperience);
  }

  async getTotalExperienceInput() {
    return await this.totalExperienceInput.getAttribute('value');
  }

  async setTitleInput(title) {
    await this.titleInput.sendKeys(title);
  }

  async getTitleInput() {
    return await this.titleInput.getAttribute('value');
  }

  async setTypeOfRoleInput(typeOfRole) {
    await this.typeOfRoleInput.sendKeys(typeOfRole);
  }

  async getTypeOfRoleInput() {
    return await this.typeOfRoleInput.getAttribute('value');
  }

  async setSkillCategoryInput(skillCategory) {
    await this.skillCategoryInput.sendKeys(skillCategory);
  }

  async getSkillCategoryInput() {
    return await this.skillCategoryInput.getAttribute('value');
  }

  async setSpecificSkillsInput(specificSkills) {
    await this.specificSkillsInput.sendKeys(specificSkills);
  }

  async getSpecificSkillsInput() {
    return await this.specificSkillsInput.getAttribute('value');
  }

  async setGeneralSkillsInput(generalSkills) {
    await this.generalSkillsInput.sendKeys(generalSkills);
  }

  async getGeneralSkillsInput() {
    return await this.generalSkillsInput.getAttribute('value');
  }

  async setClientDomainInput(clientDomain) {
    await this.clientDomainInput.sendKeys(clientDomain);
  }

  async getClientDomainInput() {
    return await this.clientDomainInput.getAttribute('value');
  }

  async setModeInput(mode) {
    await this.modeInput.sendKeys(mode);
  }

  async getModeInput() {
    return await this.modeInput.getAttribute('value');
  }

  async setEmployerInput(employer) {
    await this.employerInput.sendKeys(employer);
  }

  async getEmployerInput() {
    return await this.employerInput.getAttribute('value');
  }

  async setPrimeVendorInput(primeVendor) {
    await this.primeVendorInput.sendKeys(primeVendor);
  }

  async getPrimeVendorInput() {
    return await this.primeVendorInput.getAttribute('value');
  }

  async setEndClientInput(endClient) {
    await this.endClientInput.sendKeys(endClient);
  }

  async getEndClientInput() {
    return await this.endClientInput.getAttribute('value');
  }

  async setCurrentProjectStartDateInput(currentProjectStartDate) {
    await this.currentProjectStartDateInput.sendKeys(currentProjectStartDate);
  }

  async getCurrentProjectStartDateInput() {
    return await this.currentProjectStartDateInput.getAttribute('value');
  }

  async setCurrentProjectEndDateInput(currentProjectEndDate) {
    await this.currentProjectEndDateInput.sendKeys(currentProjectEndDate);
  }

  async getCurrentProjectEndDateInput() {
    return await this.currentProjectEndDateInput.getAttribute('value');
  }

  async setRemarksInput(remarks) {
    await this.remarksInput.sendKeys(remarks);
  }

  async getRemarksInput() {
    return await this.remarksInput.getAttribute('value');
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

  async employeeSelectLastOption(timeout?: number) {
    await this.employeeSelect
      .all(by.tagName('option'))
      .last()
      .click();
  }

  async employeeSelectOption(option) {
    await this.employeeSelect.sendKeys(option);
  }

  getEmployeeSelect(): ElementFinder {
    return this.employeeSelect;
  }

  async getEmployeeSelectedOption() {
    return await this.employeeSelect.element(by.css('option:checked')).getText();
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

export class ProfessionalDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-professional-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-professional'));

  async getDialogTitle() {
    return this.dialogTitle.getText();
  }

  async clickOnConfirmButton(timeout?: number) {
    await this.confirmButton.click();
  }
}
