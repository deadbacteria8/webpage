import { test, expect } from '@playwright/test';

test.describe('Profile page', () => {
  test('renders the current users own profile with edit button', async ({ page }) => {
    await page.goto('/profile/me');
    await expect(page.getByRole('button', { name: 'EDIT' })).toBeVisible();
  });

  test('renders connection and follower stats', async ({ page }) => {
    await page.goto('/profile/me');
    await expect(page.getByText('CONNECTIONS')).toBeVisible();
    await expect(page.getByText('FOLLOWERS')).toBeVisible();
  });


  test('header shows login for unauthenticated visitors', async ({ page }) => {
    await page.goto('/');

    await expect(page.getByRole('link', { name: 'Login' })).toBeVisible();
    await expect(page.getByRole('link', { name: 'ME' })).toHaveCount(0);
  });
});
