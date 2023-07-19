import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home',
    loadChildren: () =>
      import('./Pages/home/home.module').then((m) => m.HomeModule),
  },
  {
    path: 'login',
    loadChildren: () =>
      import('./Pages/login/login.module').then((m) => m.LoginModule),
  },
  {
    path: 'register',
    loadChildren: () =>
      import('./Pages/register/register.module').then((m) => m.RegisterModule),
  },
  {
    path: 'vendor-register/:userId',
    loadChildren: () =>
      import('./Pages/vendor-register/vendor-register.module').then((m) => m.VendorRegisterModule),
  },
  {
    path: 'forgot-password',
    loadChildren: () =>
      import('./Pages/forgot-password/forgot-password.module').then(
        (m) => m.ForgotPasswordModule
      ),
  },
  {
    path: 'admin-dashboard',
    loadChildren: () =>
      import('./Pages/admin-dashboard/admin.module').then((m) => m.AdminModule),
  },
  {
    path: 'user-dashboard',
    loadChildren: () =>
      import('./Pages/user-dashboard/user-dashboard.module').then(
        (m) => m.UserDashboardModule
      ),
  },
  {
    path: 'food-menu/:vendorId',
    loadChildren: () =>
      import('./Pages/food-menu/food-menu.module').then(
        (m) => m.FoodMenuModule
      ),
  },
  {
    path: 'shopping-cart/:vendorId',
    loadChildren: () =>
      import('./Pages/shopping-cart/shopping-cart.module').then(
        (m) => m.ShoppingCartModule
      ),
  },
  {
    path: 'order-confirmation/:vendorId/:discount',
    loadChildren: () =>
      import('./Pages/order-confirmation/order-confirmation.module').then(
        (m) => m.OrderConfirmationModule
      ),
  },
  {
    path: 'feedback',
    loadChildren: () =>
      import('./Pages/feedback/feedback.module').then((m) => m.FeedbackModule),
  },
  {
    path: 'vendor-dashboard/:vendorId',
    loadChildren: () =>
      import('./Pages/vendor-dashboard/vendor-dashboard.module').then(
        (m) => m.VendorDashboardModule
      ),
  },
  {
    path: 'create-food-item/:vendorId',
    loadChildren: () =>
      import('./Pages/vendor-dashboard/create-food-item/create-food-item.module').then(
        (m) => m.CreateFoodItemModule
      ),
  },
  {
    path: 'edit-food-item/:foodId/:vendorId',
    loadChildren: () =>
      import('./Pages/vendor-dashboard/edit-food-item/edit-food-item.module').then(
        (m) => m.EditFoodItemModule
      ),
  },
  {
    path: 'create-offers/:vendorId',
    loadChildren: () =>
      import('./Pages/vendor-dashboard/create-offers/create-offers.module').then(
        (m) => m.CreateOffersModule
      ),
  },
  {
    path: 'edit-offers/:offerId/:vendorId',
    loadChildren: () =>
      import('./Pages/vendor-dashboard/edit-offers/edit-offers.module').then(
        (m) => m.EditOffersModule
      ),
  },  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
