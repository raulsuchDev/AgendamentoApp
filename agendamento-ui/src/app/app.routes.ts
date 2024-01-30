import { Routes } from '@angular/router';
import { PaginaPrincipalComponent } from './components/pagina-principal/pagina-principal.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { CriacaoAgendamentoComponent } from './components/criacao-agendamento/criacao-agendamento.component';

export const routes: Routes = [
    { 
        path: 'pagina-principal', 
        component: PaginaPrincipalComponent        
    },
    {
        path: 'criacao-agendamento',
        component: CriacaoAgendamentoComponent
    },
    {
        path: '' ,
        redirectTo: '/pagina-principal',
        pathMatch: 'full'
    },
    {
        path: '**',
        component: PageNotFoundComponent
    }
];
