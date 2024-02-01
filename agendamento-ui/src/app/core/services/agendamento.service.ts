import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment as env } from '../../../environments/environment.dev';
import { Agendamento } from '../dto/agendamento.dto';
import { Observable } from 'rxjs';
import { NovoAgendamento } from '../types/novo-agendamento.type';
import { BaseResponse } from '../dto/base-response.dto';

@Injectable({
  providedIn: 'root'
})
export class AgendamentoService {

  private readonly agendamentoApiUrl: string = `${env.apiUrl}/agendamentos`

  constructor(private http: HttpClient) { }

  public listarAgendamentos(): Observable<Agendamento[]> {
    return this.http.get<Agendamento[]>(this.agendamentoApiUrl);
  }

  public criarAgendamento(agendamento: NovoAgendamento): Observable<BaseResponse<undefined>> {
    return this.http.post<BaseResponse<undefined>>(this.agendamentoApiUrl, agendamento);
  }
}
