import { Injectable } from '@angular/core';
import { Merchant } from './merchant';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, tap } from 'rxjs/operators';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MerchantService {

  //TODO this shouldn't be hardcoded
  private merchantsUrl = 'http://localhost:8080/merchants';

  constructor(private http: HttpClient,
              private messageService: MessageService) { }

  /** GET merchant by id. Will 404 if id not found */
  getMerchant(name: string): Observable<Merchant> {
    const url = `${this.merchantsUrl}/${name}`;
    return this.http.get<Merchant>(url)
      .pipe(
        tap(_ => this.log(`fetched merchant id=${name}`)),
        catchError(this.handleError<Merchant>(`getMerchant id=${name}`))
    );
  }

  getMerchants(): Observable<Merchant[]> {
    this.log('MerchantService: fetching merchants');
    return this.http.get<Merchant[]>(this.merchantsUrl)
      .pipe(
        tap(_ => this.log(`fetched merchants`)),
        catchError(this.handleError<Merchant[]>('getMerchants', []))
      );
  }

  /** PUT: update the merchant on the server */
  updateMerchant (merchant: Merchant): Observable<any> {
    return this.http.put(this.merchantsUrl, merchant, httpOptions)
      .pipe(
        tap(_ => this.log(`updated merchant name=${merchant.name}`)),
        catchError(this.handleError<any>('updateMerchant'))
      );
  }

  /** POST: add a new merchant to the server */
  addMerchant (merchant: Merchant): Observable<Merchant> {
    return this.http.post<Merchant>(this.merchantsUrl, merchant, httpOptions)
      .pipe(
        tap((merchant: Merchant) => this.log(`added merchant w/ id=${merchant.name}`)),
        catchError(this.handleError<Merchant>('addMerchant'))
      );
  }

  /** DELETE: delete the merchant from the server */
  deleteMerchant (merchant: Merchant | number): Observable<Merchant> {
    const id = typeof merchant === 'number' ? merchant : merchant.id;
    const url = `${this.merchantsUrl}/${id}`;

    return this.http.delete<Merchant>(url, httpOptions)
      .pipe(
        tap(_ => this.log(`deleted merchant id=${id}`)),
        catchError(this.handleError<Merchant>('deleteMerchant'))
      );
  }

  /** GET: get merchants whose name contains search term */
  searchMerchants(term: string): Observable<Merchant[]> {
    if (!term.trim()) {
      // if not search term, return empty Merchant array.
      return of([]);
    }
    const url = this.merchantsUrl + '/search/' + term;
    this.log('merchant.service.ts: Searching: ' + url);
    return this.http.get<Merchant[]>(url)
      .pipe(
        tap(_ => console.log('found merchants matching ' + term)),
        catchError(this.handleError<Merchant[]>('searchMerchants', []))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error.message); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  private log(message: string) {
    this.messageService.add('MessageService: ' + message);
  }
}
