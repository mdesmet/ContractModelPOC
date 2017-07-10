import { ContractsUiPage } from './app.po';

describe('contracts-ui App', () => {
  let page: ContractsUiPage;

  beforeEach(() => {
    page = new ContractsUiPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
