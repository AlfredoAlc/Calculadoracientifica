export type Button = {
  id: string;
  name: string;
  value?: number;
  action?: string;
};

export type ButtonLine = Array<Button>;

export type ButtonLines = Array<ButtonLine>;

export type ButtonComponent = {
  error: boolean;
  hasValue: boolean;
  onPress: Function;
};
