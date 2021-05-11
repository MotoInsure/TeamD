import { compileNgModule } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../user.model';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user : User;
  registrationNo : string;
  policyId: number;
  submit : boolean = true;

  constructor(private service: UserService, private router:Router) {
    this.user = new User();
   }

  ngOnInit(): void {
  }
  onSubmit(){
    this.service.addUser(this.user);
    this.router.navigate(['signIn']);
    //console.log(this.user.userName);
    
  }
  addVehicle(){
    this.service.addVehicle(this.registrationNo, this.user);
  }
  addPolicy(){
    this.service.addPolicy(this.policyId, this.user);
  }
  toggle(){
    this.submit=!this.submit;
  }
}