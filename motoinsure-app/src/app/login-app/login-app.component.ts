import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login-app',
  templateUrl: './login-app.component.html',
  styleUrls: ['./login-app.component.css']
})
export class LoginAppComponent implements OnInit {
  vehicleForm:FormGroup;
  isOver=false;
  userForm:FormGroup;
  isNext=false;
  vehicles: any = [
    { key: "Two Wheeler", value: "Two Wheeler" },
    { key: "Four Wheeler", value: "Four Wheeler" }
  ]
  

  constructor(private fb: FormBuilder) { 
    this.vehicleForm=this.fb.group({
      VehicleType:'',
      RTO:'',
      Brand:'',
      Model:'',
      FuelType:'',
      Variant:'',
      PurchasingYear:'',
      Price:''
    })
    this.userForm=this.fb.group({
      Name:'',
      PhoneNo:'',
      EmailId:''
    })
  }

  ngOnInit(): void {
    this.isOver=true;
  }
  next() {
    this.isNext=true;
    this.isOver=false;
  }
  


}
