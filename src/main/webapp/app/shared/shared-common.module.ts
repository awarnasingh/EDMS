import { NgModule } from '@angular/core';

import { EdmsSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
  imports: [EdmsSharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent],
  exports: [EdmsSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class EdmsSharedCommonModule {}
