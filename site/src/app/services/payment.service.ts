import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class PaymentService {
    constructor(private http: HttpClient) {}

    sendFail(userId: string, isFiled = false): Observable<any> {
        const body = {
            userId,
            isFiled
        }

        return this.http.post('http://chatbot.us-east-2.elasticbeanstalk.com/fail', body); 
    }
}