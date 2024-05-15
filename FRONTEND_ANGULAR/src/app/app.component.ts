import { Component, HostListener, OnInit } from '@angular/core';
import { AuthService } from './services/auth-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  u_data: any;

  constructor(
    private authService: AuthService,
  ){}

  ngOnInit(): void {
    // if(!this.authService.getToken()){
    //   this.u_data = this.getUData();
    // }else{
    //   localStorage.setItem("jwtToken", "");
    //   localStorage.setItem("account", "");
    //   localStorage.setItem("roles", "");
    // }
  }

  getUData(): any {
    const data = this.authService.getAccount();
    return data;
  }

// scroll to top
isShow!: boolean;
topPosToStartShowing = 100;
@HostListener('window:scroll')
checkScroll() {

  const scrollPosition = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;

  if (scrollPosition >= this.topPosToStartShowing) {
    this.isShow = true;
  } else {
    this.isShow = false;
  }
}
gotoTop() {
  window.scroll({
    top: 0,
    left: 0,
    behavior: 'smooth'
  });
}
}
