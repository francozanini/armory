import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { KindredComponent } from "./kindred/kindred.component";

const routes: Routes = [
  {path: 'kindred', component: KindredComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
