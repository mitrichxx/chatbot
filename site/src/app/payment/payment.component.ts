import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { CardValidator } from '@app/validators/card-validator';

export enum Month {
  JANUARY = '01',
  FEBRUARY = '02',
  MARCH = '03',
  APRIL = '04',
  MAY = '05',
  JUNE = '06',
  JULY = '07',
  AUGUST = '08',
  SEPTEMBER = '09',
  OCTOBER = '10',
  NOVEMBER = '11',
  DECEMBER = '12',
}

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.less'],
})
export class PaymentComponent implements OnInit {
  @ViewChild('cardHolder') cardHolderRef;

  paymentForm = this.fb.group({
    cardNumber: [
      '',
      Validators.compose([
        Validators.required,
        Validators.minLength(12),
        Validators.maxLength(19),
        CardValidator.numbersOnly,
        CardValidator.checksum,
      ]),
    ],
    cardHolder: [null, Validators.required],
    expirationMonth: ['', Validators.required],
    expirationYear: ['', Validators.required],
    ccv: [
      '',
      Validators.compose([
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(4),
        CardValidator.numbersOnly,
      ]),
    ],
  });

  public months: Array<string> = [];
  public years: Array<number> = [];

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.paymentForm.get('cardHolder').valueChanges.subscribe((val) => {
      const elRef = this.cardHolderRef.nativeElement;
      const orVal = elRef.getAttribute('data-model-value') || '';
      val = val.replace(orVal.toUpperCase(), orVal);
      elRef.setAttribute('data-model-value', val);
      elRef.value = val.toUpperCase();
      this.paymentForm.get('cardHolder').setValue(val, {
        emitEvent: false,
        emitModelToViewChange: false,
      });
    });

    this.months = this.getMonths();
    this.years = this.getYears();
  }

  getMonths(): Array<string> {
    const months: Array<string> = [];
    for (const key of Object.keys(Month)) {
      months.push(Month[key]);
    }
    return months;
  }

  getYears(): Array<number> {
    const years: Array<number> = [];
    const year = new Date().getFullYear();
    for (let i = -2; i < 5; i++) {
      years.push(year + i);
    }
    return years;
  }

  onSubmit(): void {
    alert('Thanks!');
  }

  isVisa(): boolean {
    return (
      this.paymentForm.get('cardNumber').value &&
      +this.paymentForm.get('cardNumber').value.charAt(0) === 4
    );
  }

  isMasterCard(): boolean {
    return (
      this.paymentForm.get('cardNumber').value &&
      +this.paymentForm.get('cardNumber').value.charAt(0) === 5
    );
  }
}
