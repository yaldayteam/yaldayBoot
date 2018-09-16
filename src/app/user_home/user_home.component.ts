import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AlertService } from '../_services/index';


@Component({
    templateUrl: 'user_home.component.html'
})

export class HomeComponent {
    model: any = {};
    loading = false;
    username = localStorage.getItem('currentUser');

    constructor(
        private router: Router,
        private alertService: AlertService) { }
}
