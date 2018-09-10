import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from '../_models/index';

@Injectable()
export class UserService {

    private url = 'http://localhost:8080/';

    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>('/users');
    }

    getById(id: number) {
        return this.http.get('/users/' + id);
    }

    create(user: User) {
        return this.http.post('/users', user);
    }

    update(user: User) {
        return this.http.put('/users/' + user.id, user);
    }

    delete(id: number) {
        return this.http.delete('/users/' + id);
    }
}