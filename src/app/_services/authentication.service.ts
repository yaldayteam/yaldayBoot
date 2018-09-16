import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {

    user = null;
    constructor(private http: HttpClient) { }

    login(username: string, password: string) {

        console.log('auth service: login')
        this.http.post<any>('http://localhost:8080/login', { "username": username, "password": password }, {observe: 'response'})
          .subscribe(resp => {console.log(resp.headers.get('Authorization'));
          });
        
        return this.http.post<any>('http://localhost:8080/login', { "username": username, "password": password })
            // .map(user => {
            //     // login successful if there's a jwt token in the response
            //     if (user && user.token) {
            //         // store user details and jwt token in local storage to keep user logged in between page refreshes
            //         localStorage.setItem('currentUser', JSON.stringify(user));
            //     } else { console.log('boo hoo') }
            //     return user;
            // });  
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }

    getUser() {
        this.user = localStorage.getItem('currentUser');
        console.log('added to localstorage: ' + this.user);
    }
}