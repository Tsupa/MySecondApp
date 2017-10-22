import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

import { ItemService, TypeService } from './';

@NgModule({
    imports: [
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [ItemService, TypeService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MySecondAppEntityModule {}
