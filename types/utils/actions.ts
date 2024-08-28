import * as ActionsConstants from "@/constants/buttons/actions";

export type Actions = {
  number: number;
  total?: number;
  prevAction?: string;
};

export type ActionType = keyof typeof ActionsConstants | string;

export type GradeType =
  | typeof ActionsConstants.DEG
  | typeof ActionsConstants.RAD;
