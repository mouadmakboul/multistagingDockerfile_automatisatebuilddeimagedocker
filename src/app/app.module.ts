import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router'; // Ajoute cette ligne

import { AppComponent } from './app.component';
import { ClientListComponent } from './client-list/client-list.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([ // Ajoute cette ligne pour définir les routes
      { path: 'clients', component: ClientListComponent }, // Ajoute la route pour ton composant
      { path: '', redirectTo: '/clients', pathMatch: 'full' } // Redirige la route par défaut vers /clients
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
