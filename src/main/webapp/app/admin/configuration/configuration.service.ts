import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { SERVER_API_URL, RESPONSE, CONTEXTS, BOOTSTRAP, BEANS, EDMS, PROPERTY_SOURCES, MANAGEMENT_ENV, NAME, PROPERTIES, VALUE, MANAGEMENT_CONFIGPROPS } from 'app/app.constants';

@Injectable({ providedIn: 'root' })
export class JhiConfigurationService {
  constructor(private http: HttpClient) {}

  get(): Observable<any> {
    return this.http.get(SERVER_API_URL + MANAGEMENT_CONFIGPROPS, { observe: RESPONSE }).pipe(
      map((res: HttpResponse<any>) => {
        const properties: any[] = [];
        const propertiesObject = this.getConfigPropertiesObjects(res.body);
        for (const key in propertiesObject) {
          if (propertiesObject.hasOwnProperty(key)) {
            properties.push(propertiesObject[key]);
          }
        }

        return properties.sort((propertyA, propertyB) => {
          return propertyA.prefix === propertyB.prefix ? 0 : propertyA.prefix < propertyB.prefix ? -1 : 1;
        });
      })
    );
  }

  getConfigPropertiesObjects(res: Object) {
    // This code is for Spring Boot 2
    if (res[CONTEXTS] !== undefined) {
      for (const key in res[CONTEXTS]) {
        // If the key is not bootstrap, it will be the ApplicationContext Id
        // For default app, it is baseName
        // For microservice, it is baseName-1
        if (!key.startsWith(BOOTSTRAP)) {
          return res[CONTEXTS][key][BEANS];
        }
      }
    }
    // by default, use the default ApplicationContext Id
    return res[CONTEXTS][EDMS][BEANS];
  }

  getEnv(): Observable<any> {
    return this.http.get(SERVER_API_URL + MANAGEMENT_ENV, { observe: RESPONSE }).pipe(
      map((res: HttpResponse<any>) => {
        const properties: any = {};
        const propertySources = res.body[PROPERTY_SOURCES];

        for (const propertyObject of propertySources) {
          const name = propertyObject[NAME];
          const detailProperties = propertyObject[PROPERTIES];
          const vals: any[] = [];
          for (const keyDetail in detailProperties) {
            if (detailProperties.hasOwnProperty(keyDetail)) {
              vals.push({ key: keyDetail, val: detailProperties[keyDetail][VALUE] });
            }
          }
          properties[name] = vals;
        }
        return properties;
      })
    );
  }
}
