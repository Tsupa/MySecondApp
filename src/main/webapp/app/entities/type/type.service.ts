import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { SERVER_API_URL } from '../../app.constants';
import { Type } from './type.model';

@Injectable()
export class TypeService {
    private resourceUrl = SERVER_API_URL + 'api/types/';

    constructor(private http: Http) {}

    getActivableTypes(): Observable<Type[]> {
        return this.http.get(this.resourceUrl + 'all').map((res: Response) => res.json());
    }

}
