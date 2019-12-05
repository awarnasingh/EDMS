import { Injectable } from '@angular/core';
import { SessionStorageService } from 'ngx-webstorage';
import { PREVIOUS_STATE, DESTINATION_STATE, PREVIOUS_URL } from 'app/app.constants';

@Injectable({ providedIn: 'root' })
export class StateStorageService {
  constructor(private $sessionStorage: SessionStorageService) {}

  getPreviousState() {
    return this.$sessionStorage.retrieve(PREVIOUS_STATE);
  }

  resetPreviousState() {
    this.$sessionStorage.clear(PREVIOUS_STATE);
  }

  storePreviousState(previousStateName, previousStateParams) {
    const previousState = { name: previousStateName, params: previousStateParams };
    this.$sessionStorage.store(PREVIOUS_STATE, previousState);
  }

  getDestinationState() {
    return this.$sessionStorage.retrieve(DESTINATION_STATE);
  }

  storeUrl(url: string) {
    this.$sessionStorage.store(PREVIOUS_URL, url);
  }

  getUrl() {
    return this.$sessionStorage.retrieve(PREVIOUS_URL);
  }

  storeDestinationState(destinationState, destinationStateParams, fromState) {
    const destinationInfo = {
      destination: {
        name: destinationState.name,
        data: destinationState.data
      },
      params: destinationStateParams,
      from: {
        name: fromState.name
      }
    };
    this.$sessionStorage.store(DESTINATION_STATE, destinationInfo);
  }
}
