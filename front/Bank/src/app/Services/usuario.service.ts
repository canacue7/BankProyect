import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Usuario } from '../Models/Usuario';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiServerUrl= environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.apiServerUrl}/usuario/all`); 
  }
  public getUsuarioById(usuarioId: number): Observable<Usuario>{
    return this.http.get<Usuario>(`${this.apiServerUrl}/usuario/find/${usuarioId}`); 
  }

  public addUsuario(usuario: Usuario): Observable<Usuario> {
    console.log(usuario);
    return this.http.post<Usuario>(`${this.apiServerUrl}/usuario/add`, usuario);
  }
  public updateUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(`${this.apiServerUrl}/usuario/update`, usuario);
  }
  public deleteUsuario(usuarioId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/usuario/delete/${usuarioId}`);
  }
}