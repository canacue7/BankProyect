import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Cuenta } from '../Models/Cuenta';

@Injectable({
  providedIn: 'root'
})
export class CuentaService {
  private apiServerUrl= environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getallCuentas(id_usuario: number): Observable<Cuenta[]> {
    return this.http.get<Cuenta[]>(`${this.apiServerUrl}/cuenta/all/${id_usuario}`); 
  }
  // public getCuentabyId(id: number): Observable<Cuenta>{
  //   return this.http.get<Usuario>(`${this.apiServerUrl}/usuario/find/${usuarioId}`); 
  // }

  public addCuenta(cuenta:Cuenta, idUser:number): Observable<Cuenta> {
    return this.http.post<Cuenta>(`${this.apiServerUrl}/cuenta/add/${idUser}`, cuenta);
  }
  // public updateUsuario(usuario: Usuario): Observable<Usuario> {
  //   return this.http.put<Usuario>(`${this.apiServerUrl}/usuario/update`, usuario);
  // }
  // public deleteUsuario(usuarioId: number): Observable<void> {
  //   return this.http.delete<void>(`${this.apiServerUrl}/usuario/delete/${usuarioId}`);
  // }
}