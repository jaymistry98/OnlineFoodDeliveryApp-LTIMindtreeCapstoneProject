import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HttpGeneralService {
  url: string;
  constructor(public http: HttpClient) {
    this.url = environment.apiRoute;
  }

  post(apiRoute: string, body: any) {
    console.log(body);
    return this.http.post(`${this.url + apiRoute}`, body, { headers: this.getHttpHeaders() });
  }

  get(apiRoute: string) {
    return this.http.get(`${this.url + apiRoute}`, { headers: this.getHttpHeaders() });
  }

  put(apiRoute: string, body: any) {
    return this.http.put(`${this.url + apiRoute}`, body, { headers: this.getHttpHeaders() });
  }

  delete(apiRoute: string) {
    return this.http.delete(`${this.url + apiRoute}`, { headers: this.getHttpHeaders() });
  }

  getHttpHeaders(): HttpHeaders {
    return new HttpHeaders().set("key", "value");
  }
}