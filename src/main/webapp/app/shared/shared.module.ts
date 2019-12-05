import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { EdmsSharedLibsModule, EdmsSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [EdmsSharedLibsModule, EdmsSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [EdmsSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EdmsSharedModule {
  static forRoot() {
    return {
      ngModule: EdmsSharedModule
    };
  }
}
