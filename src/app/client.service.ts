import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface Client {
  id: number;
  nom_client: string;
  adresse_client: string;
}

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private apiUrl = 'http://localhost:1000/api/clients'; // URL de l'API Spring Boot

  constructor(private http: HttpClient) {}

  // Obtenir tous les clients
  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.apiUrl);
  }
}
