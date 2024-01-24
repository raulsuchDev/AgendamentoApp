import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment as env } from '../../../environments/environment.dev';
import { Agendamento } from '../dto/agendamento';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgendamentoService {

  private readonly agendamentoApiUrl: string = `${env.apiUrl}/agendamentos`

  constructor(private http: HttpClient) { }

  public listarAgendamentos() {
    return this.http.get(this.agendamentoApiUrl);
  }

  public criarAgendamento(agendamento: Agendamento) {
    return this.http.post(this.agendamentoApiUrl, agendamento)
      .pipe(tap(res => console.log(res)));
  }
}
