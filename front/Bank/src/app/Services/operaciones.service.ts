import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Operaciones } from '../Models/Operaciones';

@Injectable({
  providedIn: 'root'
})
export class OperacionesService {
  private apiServerUrl= environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getAllOps(id_cuenta: number): Observable<Operaciones[]> {
    return this.http.get<Operaciones[]>(`${this.apiServerUrl}/operaciones/all/${id_cuenta}`); 
  }
  // public retirSaldo(operaciones:Operaciones): Observable<Operaciones[]> {
  //   return this.http.post<Operaciones>(`${this.apiServerUrl}/operaciones/addRetiro/1`); 
  // }
  // public addSaldo(ops: Operaciones): Observable<Operaciones[]> {
  //   return this.http.post<Operaciones>(`${this.apiServerUrl}/operaciones/addSaldo/${id_cuenta}`); 
  // }
  // public trSaldo(ops: Operaciones): Observable<Operaciones[]> {
  //   return this.http.post<Operaciones>(`${this.apiServerUrl}/operaciones/${id_cuenta}/cuentaDestino/${id_cuenta_destino}`); 
  // }

}
