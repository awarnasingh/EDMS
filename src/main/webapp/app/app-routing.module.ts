import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {errorRoute, navbarRoute} from './layouts';
import {ADMIN_PATH, DEBUG_INFO_ENABLED} from 'app/app.constants';

const LAYOUT_ROUTES = [navbarRoute, ...errorRoute];

@NgModule({
    imports: [
        RouterModule.forRoot(
            [
                {
                    path: ADMIN_PATH,
                    loadChildren: './admin/admin.module#EdmsAdminModule'
                },
                ...LAYOUT_ROUTES
            ],
            {enableTracing: DEBUG_INFO_ENABLED}
        )
    ],
    exports: [RouterModule]
})
export class EdmsAppRoutingModule {
}
