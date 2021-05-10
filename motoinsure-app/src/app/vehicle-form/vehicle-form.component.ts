import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

export interface Transaction {
  specification: string;
  values: string;
}


@Component({
  selector: 'app-vehicle-form',
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.css']
})
export class VehicleFormComponent implements OnInit {
  // [x: string]: any;
  vehicleForm:FormGroup;
  isOver=false;
  userForm:FormGroup;
  isNext=false;
  ELEMENT_DATA: Transaction[] =  [
    {specification: 'Vehicle Type', values: ''},
    {specification: 'RTO', values: ''},
    {specification: 'Brand', values: ''},
    {specification: 'Model', values: ''},
    {specification: 'Fuel Type', values: ''},
    {specification: 'Variant', values: ''},
    {specification: 'Purchasing Year ', values: ''},
    {specification: 'Price', values: ''},
  ];
  displayedColumns: string[] = ['specification', 'values'];
  dataSource = this.ELEMENT_DATA;

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
    this.ELEMENT_DATA[0].values = this.vehicleForm.value.VehicleType;
    this.ELEMENT_DATA[1].values = this.vehicleForm.value.RTO;
    this.ELEMENT_DATA[2].values = this.vehicleForm.value.Brand;
    this.ELEMENT_DATA[3].values = this.vehicleForm.value.Model;
    this.ELEMENT_DATA[4].values = this.vehicleForm.value.FuelType;
    this.ELEMENT_DATA[5].values = this.vehicleForm.value.Variant;
    this.ELEMENT_DATA[6].values = this.vehicleForm.value.PurchasingYear;
    this.ELEMENT_DATA[7].values = this.vehicleForm.value.Price;

    console.log('vehicleForm', this.vehicleForm.value);
  }
  
}
