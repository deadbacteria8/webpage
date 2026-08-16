import { test, expect } from '@playwright/test';

test.describe('Feed page', () => {
  test.beforeEach(async ({ page }) => {
    await page.goto('/');
  });


  test('shows engagement action buttons on each post', async ({ page }) => {
    await expect(page.getByRole('button', { name: 'LIKE' }).first()).toBeVisible();
    await expect(page.getByRole('button', { name: 'COMMENT' }).first()).toBeVisible();
    await expect(page.getByRole('button', { name: 'SHARE' }).first()).toBeVisible();
  });

});
