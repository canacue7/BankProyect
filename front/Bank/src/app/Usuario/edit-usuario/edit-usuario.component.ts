import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/Models/Usuario';
import { UsuarioService } from 'src/app/Services/usuario.service';

@Component({
  selector: 'app-edit-usuario',
  templateUrl: './edit-usuario.component.html',
  styleUrls: ['./edit-usuario.component.css']
})
export class EditUsuarioComponent implements OnInit {
  usuario: Usuario;

  constructor(private usuarioService: UsuarioService, private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
  }

  Editar(){
    // let id=localStorage.getItem("id");
    // this.service.getUsuarioById(+id).subscribe(data=>{this.usuarios=data})
    const userId = this.route.snapshot.paramMap.get('id'); 
    console.log(userId)
    this.usuarioService.getUsuarioById(+userId).subscribe(data=>{this.usuario=data})
  }

  Actualizar(usuario:Usuario){
    this.usuarioService.updateUsuario(usuario).subscribe(data=>{this.usuario=data;
    alert("Se Actualizó exitosamente")})
  }

}
