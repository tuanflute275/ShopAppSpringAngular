# FRONTEND_ANGULAR

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.1.0.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.

ng g c --skip-tests=true category


<header>
  <nav
    class="navbar navbar-expand-sm navbar-light px-4 py-2 d-flex align-items-center"
  >
    <a class="navbar-brand" routerLink="/">
      <img [src]="logo" alt="" />
    </a>
    <button
      class="navbar-toggler d-lg-none"
      type="button"
      data-toggle="collapse"
      data-target="#collapsibleNavId"
      aria-controls="collapsibleNavId"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavId">
      <ul class="navbar-nav m-auto mt-2 py-4 mt-lg-0 menu">
        <li class="nav-item active">
          <a class="nav-link" routerLink="/"
            >Home <span class="sr-only">(current)</span></a
          >
        </li>
        <li class="nav-item active">
          <a class="nav-link" routerLink="/product"
            >Shop <span class="sr-only">(current)</span></a
          >
        </li>
        <li class="nav-item active">
          <a class="nav-link" routerLink="/faq"
            >Faq <span class="sr-only">(current)</span></a
          >
        </li>
       
        <li class="nav-item active">
          <a class="nav-link" routerLink="/blog"
            >Blog <span class="sr-only">(current)</span></a
          >
        </li>
        <li class="nav-item active">
          <a class="nav-link" routerLink="/contact"
            >Contact <span class="sr-only">(current)</span></a
          >
        </li>
      </ul>

      <p *ngIf="u_data">
        Hello, <b class="text-capitalize">{{ u_data.userName }}</b>
      </p>

      <div class="header_account">
        <ul class="d-flex align-items-center">

          <li class="nav-item nav-icon dropdown" *ngIf="u_data">
            <a [routerLink]="['/cart']" class="search-toggle iq-waves-effect text-gray rounded">
              <i class="ri-shopping-cart-2-line"></i>
              <span class="badge badge-danger count-cart rounded-circle">{{ countCart }}</span>
            </a>

          </li>
          <!-- <li class="line-height pt-3" *ngIf="u_data">
            <a href="#" class="search-toggle iq-waves-effect d-flex align-items-center">
              <img src="{{u_data.userAvatar ? u_data.userAvatar : imageDefault}}" class="img-fluid rounded-circle mr-3" alt="user">
              <div class="caption">
                <h6 class="mb-1 line-height">{{ u_data.userName }}</h6>
                <p class="mb-0 text-primary">{{ u_data.userEmail }}</p>
              </div>
            </a>
            <div class="iq-sub-dropdown iq-user-dropdown">
              <div class="iq-card shadow-none m-0">
                <div class="iq-card-body p-0 ">
                  <div class="bg-primary p-3">
                    <h5 class="mb-0 text-white line-height">Xin Chào {{ u_data.userName }}</h5>
                  </div>
                  <a (click)="onProfile()" href="javascript:void();" class="iq-sub-card iq-bg-primary-hover">
                    <div class="media align-items-center">
                      <div class="rounded iq-card-icon iq-bg-primary">
                        <i class="ri-file-user-line"></i>
                      </div>
                      <div class="media-body ml-3">
                        <h6 class="mb-0 ">Tài khoản của tôi</h6>
                      </div>
                    </div>
                  </a>
                  <a [routerLink]="['/order']" class="iq-sub-card iq-bg-primary-hover">
                    <div class="media align-items-center">
                      <div class="rounded iq-card-icon iq-bg-primary">
                        <i class="ri-account-box-line"></i>
                      </div>
                      <div class="media-body ml-3">
                        <h6 class="mb-0 ">Đơn hàng của tôi</h6>
                      </div>
                    </div>
                  </a>
                  <div class="d-inline-block w-100 text-center p-3">
                    <a class="bg-primary iq-sign-btn" href="javascript:void(0)" (click)="logout()" role="button">Sign
                      out<i class="ri-login-box-line ml-2"></i></a>
                  </div>
                </div>
              </div>
            </div>
          </li> -->
          <li class="line-height pt-3" *ngIf="!u_data">
            <a href="#" class="search-toggle iq-waves-effect d-flex align-items-center">
              <img src="../../../../../assets/images/default.png" class="img-fluid rounded-circle mr-3" alt="user">
              <div class="caption">
                <h6 class="mb-1 line-height">login</h6>
                <p class="mb-0 text-primary">login</p>
              </div>
            </a>
            <div class="iq-sub-dropdown iq-user-dropdown">
              <div class="iq-card shadow-none m-0">
                <div class="iq-card-body p-0 ">
                  <div class="bg-primary p-3">
                    <h5 class="mb-0 text-white line-height">login</h5>
                  </div>
                  <div class="d-inline-block w-100 text-center p-3">
                    <a class="bg-primary iq-sign-btn" [routerLink]="['/login']" role="button">Login<i
                        class="ri-login-box-line ml-2"></i></a>
                  </div>
                </div>
              </div>
            </div>
          </li>

          <li *ngIf="u_data" class="header_shopping_cart">
            <a routerLink="/cart">
              <i class="cil-cart font-weight-bold" style="color: #171717"></i>
            </a>
            <span class="item_count">{{ dataCount }}</span>
          </li>
          <li *ngIf="u_data">
            <div class="dropdown">
              <a
                class="btn dropdown-toggle btn-avatar"
                href="#"
                role="button"
                data-toggle="dropdown"
                aria-expanded="false"
              >
                <img
                  [src]="avatar"
                  class="avatar"
                  style="position: relative; border-radius: 50%"
                  alt=""
                />
              </a>
              <div class="dropdown-menu show-avatar text-dark">
                <a class="dropdown-item btn-logout" (click)="logout()"
                  >Logout</a
                >
              </div>
            </div>
          </li>

          <li *ngIf="!u_data" class="header_heart">
            <a routerLink="/login">
              <i class="far fa-user"></i>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</header>
