import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { BUS } from './bus.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class BUSService {

    private resourceUrl = 'api/b-uses';

    constructor(private http: Http) { }

    create(bUS: BUS): Observable<BUS> {
        const copy = this.convert(bUS);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    update(bUS: BUS): Observable<BUS> {
        const copy = this.convert(bUS);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    find(id: number): Observable<BUS> {
        return this.http.get(`${this.resourceUrl}/${id}`).map((res: Response) => {
            return res.json();
        });
    }

    query(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceUrl, options)
            .map((res: Response) => this.convertResponse(res));
    }

    delete(id: number): Observable<Response> {
        return this.http.delete(`${this.resourceUrl}/${id}`);
    }

    private convertResponse(res: Response): ResponseWrapper {
        const jsonResponse = res.json();
        return new ResponseWrapper(res.headers, jsonResponse, res.status);
    }

    private convert(bUS: BUS): BUS {
        const copy: BUS = Object.assign({}, bUS);
        return copy;
    }
}
