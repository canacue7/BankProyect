import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Operaciones } from 'src/app/Models/Operaciones';
import { OperacionesService } from 'src/app/Services/operaciones.service';

@Component({
  selector: 'app-listar-operaciones',
  templateUrl: './listar-operaciones.component.html',
  styleUrls: ['./listar-operaciones.component.css']
})
export class ListarOperacionesComponent implements OnInit {
  ops:Operaciones[];

  constructor(private operacionesService: OperacionesService, private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    const userId = this.route.snapshot.paramMap.get('id'); 
    console.log(userId)
    this.operacionesService.getAllOps(+userId).subscribe(data=>{this.ops=data})
  }

}
