import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { IdeComponent } from './pages/ide/ide.component';
import { CaptchasComponent } from './pages/captchas/captchas.component';
import { ReportsComponent } from './pages/reports/reports.component';

const routes: Routes = [
  {path:'', component : HomeComponent},
  {path:'ide', component : IdeComponent},
  {path:'captchas', component : CaptchasComponent},
  {path:'reports', component : ReportsComponent},
  {path:'**', redirectTo : '', pathMatch: 'full'}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
