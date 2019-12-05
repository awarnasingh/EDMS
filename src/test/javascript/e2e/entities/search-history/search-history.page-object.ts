import { browser, ExpectedConditions, element, by, ElementFinder } from 'protractor';

export class SearchHistoryComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-search-history div table .btn-danger'));
  title = element.all(by.css('jhi-search-history div h2#page-heading span')).first();

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

export class SearchHistoryUpdatePage {
  pageTitle = element(by.id('jhi-search-history-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));
  userIDInput = element(by.id('field_userID'));
  searchNameInput = element(by.id('field_searchName'));
  empTypeInput = element(by.id('field_empType'));
  domainInput = element(by.id('field_domain'));
  fromExperienceInput = element(by.id('field_fromExperience'));
  toExperienceInput = element(by.id('field_toExperience'));
  locationInput = element(by.id('field_location'));
  statusInput = element(by.id('field_status'));
  endClientInput = element(by.id('field_endClient'));
  skillsInput = element(by.id('field_skills'));
  employeeNameInput = element(by.id('field_employeeName'));

  async getPageTitle() {
    return this.pageTitle.getText();
  }

  async setUserIDInput(userID) {
    await this.userIDInput.sendKeys(userID);
  }

  async getUserIDInput() {
    return await this.userIDInput.getAttribute('value');
  }

  async setSearchNameInput(searchName) {
    await this.searchNameInput.sendKeys(searchName);
  }

  async getSearchNameInput() {
    return await this.searchNameInput.getAttribute('value');
  }

  async setEmpTypeInput(empType) {
    await this.empTypeInput.sendKeys(empType);
  }

  async getEmpTypeInput() {
    return await this.empTypeInput.getAttribute('value');
  }

  async setDomainInput(domain) {
    await this.domainInput.sendKeys(domain);
  }

  async getDomainInput() {
    return await this.domainInput.getAttribute('value');
  }

  async setFromExperienceInput(fromExperience) {
    await this.fromExperienceInput.sendKeys(fromExperience);
  }

  async getFromExperienceInput() {
    return await this.fromExperienceInput.getAttribute('value');
  }

  async setToExperienceInput(toExperience) {
    await this.toExperienceInput.sendKeys(toExperience);
  }

  async getToExperienceInput() {
    return await this.toExperienceInput.getAttribute('value');
  }

  async setLocationInput(location) {
    await this.locationInput.sendKeys(location);
  }

  async getLocationInput() {
    return await this.locationInput.getAttribute('value');
  }

  async setStatusInput(status) {
    await this.statusInput.sendKeys(status);
  }

  async getStatusInput() {
    return await this.statusInput.getAttribute('value');
  }

  async setEndClientInput(endClient) {
    await this.endClientInput.sendKeys(endClient);
  }

  async getEndClientInput() {
    return await this.endClientInput.getAttribute('value');
  }

  async setSkillsInput(skills) {
    await this.skillsInput.sendKeys(skills);
  }

  async getSkillsInput() {
    return await this.skillsInput.getAttribute('value');
  }

  async setEmployeeNameInput(employeeName) {
    await this.employeeNameInput.sendKeys(employeeName);
  }

  async getEmployeeNameInput() {
    return await this.employeeNameInput.getAttribute('value');
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

export class SearchHistoryDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-searchHistory-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-searchHistory'));

  async getDialogTitle() {
    return this.dialogTitle.getText();
  }

  async clickOnConfirmButton(timeout?: number) {
    await this.confirmButton.click();
  }
}
