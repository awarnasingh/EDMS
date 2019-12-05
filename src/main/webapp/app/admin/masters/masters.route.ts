import {Route} from '@angular/router';

import {MastersComponent} from './masters.component';
import {MASTER} from "app/app.constants";

export const mastersRoute: Route = {
    path: MASTER,
    component: MastersComponent
};
