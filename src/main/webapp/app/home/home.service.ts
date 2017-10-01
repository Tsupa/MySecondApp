import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { SERVER_API_URL } from '../app.constants';

@Injectable()
export class Home {

    constructor(private http: Http) {}

    getAllItems(): Observable<any> {
        return this.http.get(SERVER_API_URL + 'api/items');
    }
}
