import { test, expect } from '@playwright/test';

test.describe('Login page', () => {
  test.beforeEach(async ({ page }) => {
    await page.goto('/login');
  });

  test('renders the sign in form', async ({ page }) => {
    await expect(page.getByRole('heading', { name: 'Sign in' })).toBeVisible();

    await expect(page.getByLabel('USERNAME')).toBeVisible();
    await expect(page.getByLabel('PASSWORD')).toBeVisible();
    await expect(page.getByRole('button', { name: 'SIGN IN' })).toBeVisible();
  });


  test('shows validation when submitting an empty form', async ({ page }) => {
    await page.getByRole('button', { name: 'SIGN IN' }).click();

    await expect(page).toHaveURL(/\/login$/);
    await expect(page.getByLabel('USERNAME')).toBeVisible();
  });

  test('accepts a username and password', async ({ page }) => {
    await page.getByLabel('USERNAME').fill('randomusername');
    await page.getByLabel('PASSWORD').fill('password123');

    await expect(page.getByLabel('USERNAME')).toHaveValue('randomusername');
    await expect(page.getByLabel('PASSWORD')).toHaveValue('password123');
  });
});
