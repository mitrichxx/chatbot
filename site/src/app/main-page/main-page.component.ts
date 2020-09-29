import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.less'],
})
export class MainPageComponent {
  cards = [
    {
      title: 'Молодцов Дмитрий Сергеевич',
      avatart: {
        'background-image': 'url("/assets/images/teams/mds.jpg")',
        'background-size': 'cover',
      },
      post: 'Главный инженер по разработке',
      city: 'Брянск',
      phone: '8-78917047',
      email: 'Molodtsov.D.Se@sberbank.ru',
      cols: 1,
      rows: 1,
    },
    {
      title: 'Карасев Николай Александрович',
      avatart: {
        'background-image': 'url("/assets/images/teams/kna.jpg")',
        'background-size': 'cover',
      },
      post: 'Руководитель направления',
      city: 'Брянск',
      phone: '8-78917044',
      email: 'Karasev.N.Al@sberbank.ru',
      cols: 1,
      rows: 1,
    },
    {
      title: 'Терехов Максим Геннадьевич',
      avatart: {
        'background-image': 'url("/assets/images/teams/tmg.jpg")',
        'background-size': 'cover',
      },
      post: 'Главный инженер по разработке',
      city: 'Брянск',
      phone: '8-78917034',
      email: 'Terekhov.M.Ge@sberbank.ru',
      cols: 1,
      rows: 1,
    },
    {
      title: 'Майорова Елена Александровна',
      avatart: {
        'background-image': 'url("/assets/images/teams/mea.jpg")',
        'background-size': 'cover',
      },
      post: 'Руководитель направления',
      city: 'Брянск',
      phone: '8-78917053',
      email: 'Mayorova.E.Aleksa@sberbank.ru',
      cols: 1,
      rows: 1,
    },
    {
      title: 'Повышев Николай Владимирович',
      avatart: {
        'background-image': 'url("/assets/images/teams/pnv.jpg")',
        'background-size': 'cover',
      },
      post: 'Главный инженер по разработке',
      city: 'Брянск',
      phone: '8-78917069',
      email: 'Povyshev.N.Vl@sberbank.ru',
      cols: 1,
      rows: 1,
    },
  ];

  step = 0;
  col = 1;

  constructor(breakpointObserver: BreakpointObserver) {
    breakpointObserver.observe([
      Breakpoints.Medium,
      Breakpoints.Small,
      Breakpoints.XSmall
    ]).subscribe(result => {
      if (result.matches) {
        this.col = 1;
      } else {
        this.col = 5;
      }
    });
  }

  setStep(index: number): void {
    this.step = index;
  }

  nextStep(): void {
    this.step++;
  }

  prevStep(): void {
    this.step--;
  }
}
