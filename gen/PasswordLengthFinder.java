/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;


public class PasswordLengthFinder extends ASTRAClass {
	public PasswordLengthFinder() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"PasswordLengthFinder", new int[] {18,9,18,92},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "Cracker",false),
				new Predicate("taskPasswordLength", new Term[] {
					new Variable(Type.STRING, "C",false)
				})
			),
			new Predicate("cracker", new Term[] {
				new Variable(Type.STRING, "Cracker")
			}),
			new Block(
				"PasswordLengthFinder", new int[] {18,91,30,5},
				new Statement[] {
					new If(
						"PasswordLengthFinder", new int[] {19,9,30,5},
						new Comparison("==",
							new Variable(Type.STRING, "C"),
							Primitive.newPrimitive("")
						),
						new Block(
							"PasswordLengthFinder", new int[] {19,21,21,10},
							new Statement[] {
								new Send("PasswordLengthFinder", new int[] {20,12,20,92},
									new Performative("refuse"),
									new Variable(Type.STRING, "Cracker"),
									new Predicate("state", new Term[] {
										Operator.newOperator('+',
											new ModuleTerm("system", Type.STRING,
												new Predicate("name", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("PasswordLengthFinder","system")).name(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.System) visitor.agent().getModule("PasswordLengthFinder","system")).name(
														);
													}
												}
											),
											Primitive.newPrimitive(" refused to find password length")
										)
									})
								)
							}
						),
						new Block(
							"PasswordLengthFinder", new int[] {21,16,30,5},
							new Statement[] {
								new Send("PasswordLengthFinder", new int[] {22,12,22,90},
									new Performative("agree"),
									new Variable(Type.STRING, "Cracker"),
									new Predicate("state", new Term[] {
										Operator.newOperator('+',
											new ModuleTerm("system", Type.STRING,
												new Predicate("name", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("PasswordLengthFinder","system")).name(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.System) visitor.agent().getModule("PasswordLengthFinder","system")).name(
														);
													}
												}
											),
											Primitive.newPrimitive(" agreed to find password length")
										)
									})
								),
								new TryRecover(
									"PasswordLengthFinder", new int[] {24,12,29,9},
									new Block(
										"PasswordLengthFinder", new int[] {24,16,26,13},
										new Statement[] {
											new Subgoal(
												"PasswordLengthFinder", new int[] {25,16,26,13},
												new Goal(
													new Predicate("doPasswordLength", new Term[] {
														new Variable(Type.STRING, "C")
													})
												)
											)
										}
									),
									new Block(
										"PasswordLengthFinder", new int[] {26,22,29,9},
										new Statement[] {
											new Send("PasswordLengthFinder", new int[] {27,16,27,95},
												new Performative("failure"),
												new Variable(Type.STRING, "Cracker"),
												new Predicate("state", new Term[] {
													Operator.newOperator('+',
														new ModuleTerm("system", Type.STRING,
															new Predicate("name", new Term[] {}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((astra.lang.System) intention.getModule("PasswordLengthFinder","system")).name(
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((astra.lang.System) visitor.agent().getModule("PasswordLengthFinder","system")).name(
																	);
																}
															}
														),
														Primitive.newPrimitive(" fails to find password length")
													)
												})
											)
										}
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"PasswordLengthFinder", new int[] {32,9,32,39},
			new GoalEvent('+',
				new Goal(
					new Predicate("doPasswordLength", new Term[] {
						new Variable(Type.STRING, "C",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"PasswordLengthFinder", new int[] {32,38,83,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "alphabet"),
						"PasswordLengthFinder", new int[] {33,8,83,5},
						Primitive.newPrimitive("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
					),
					new Declaration(
						new Variable(Type.INTEGER, "distance"),
						"PasswordLengthFinder", new int[] {34,8,83,5},
						Primitive.newPrimitive(1)
					),
					new Declaration(
						new Variable(Type.LIST, "DISTANCE"),
						"PasswordLengthFinder", new int[] {35,8,83,5},
						new ListTerm(new Term[] {

						})
					),
					new Declaration(
						new Variable(Type.LIST, "COUNT"),
						"PasswordLengthFinder", new int[] {36,8,83,5},
						new ListTerm(new Term[] {

						})
					),
					new Declaration(
						new Variable(Type.INTEGER, "i"),
						"PasswordLengthFinder", new int[] {38,8,83,5},
						Primitive.newPrimitive(0)
					),
					new While(
						"PasswordLengthFinder", new int[] {40,8,83,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "i"),
							Operator.newOperator('-',
								new ModuleTerm("support", Type.INTEGER,
									new Predicate("length", new Term[] {
										new Variable(Type.STRING, "alphabet")
									}),
									new ModuleTermAdaptor() {
										public Object invoke(Intention intention, Predicate predicate) {
											return ((aop.utils.Support) intention.getModule("PasswordLengthFinder","support")).length(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((aop.utils.Support) visitor.agent().getModule("PasswordLengthFinder","support")).length(
												(java.lang.String) visitor.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								Primitive.newPrimitive(1)
							)
						),
						new Block(
							"PasswordLengthFinder", new int[] {40,48,69,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "x"),
									"PasswordLengthFinder", new int[] {41,12,69,9},
									Primitive.newPrimitive(0)
								),
								new While(
									"PasswordLengthFinder", new int[] {43,12,69,9},
									new Comparison("<",
										new Variable(Type.INTEGER, "x"),
										new ModuleTerm("support", Type.INTEGER,
											new Predicate("length", new Term[] {
												new Variable(Type.STRING, "C")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((aop.utils.Support) intention.getModule("PasswordLengthFinder","support")).length(
														(java.lang.String) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((aop.utils.Support) visitor.agent().getModule("PasswordLengthFinder","support")).length(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0))
													);
												}
											}
										)
									),
									new Block(
										"PasswordLengthFinder", new int[] {43,42,67,13},
										new Statement[] {
											new If(
												"PasswordLengthFinder", new int[] {45,16,67,13},
												new ModuleFormula("support",
													new Predicate("equal", new Term[] {
														new ModuleTerm("strs", Type.CHAR,
															new Predicate("charAt", new Term[] {
																new Variable(Type.STRING, "C"),
																new Variable(Type.INTEGER, "x")
															}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((astra.lang.Strings) intention.getModule("PasswordLengthFinder","strs")).charAt(
																		(java.lang.String) intention.evaluate(predicate.getTerm(0)),
																		(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((astra.lang.Strings) visitor.agent().getModule("PasswordLengthFinder","strs")).charAt(
																		(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																		(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
																	);
																}
															}
														),
														new ModuleTerm("strs", Type.CHAR,
															new Predicate("charAt", new Term[] {
																new Variable(Type.STRING, "alphabet"),
																new Variable(Type.INTEGER, "i")
															}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((astra.lang.Strings) intention.getModule("PasswordLengthFinder","strs")).charAt(
																		(java.lang.String) intention.evaluate(predicate.getTerm(0)),
																		(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((astra.lang.Strings) visitor.agent().getModule("PasswordLengthFinder","strs")).charAt(
																		(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																		(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
																	);
																}
															}
														)
													}),
												new ModuleFormulaAdaptor() {
														public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((aop.utils.Support) visitor.agent().getModule("PasswordLengthFinder","support")).equal(
																(java.lang.Character) visitor.evaluate(predicate.getTerm(0)),
																(java.lang.Character) visitor.evaluate(predicate.getTerm(1))
															);
													}
												}
													),
												new Block(
													"PasswordLengthFinder", new int[] {45,80,63,17},
													new Statement[] {
														new If(
															"PasswordLengthFinder", new int[] {47,20,63,17},
															new NOT(
																new ModuleFormula("prelude",
																	new Predicate("contains", new Term[] {
																		new Variable(Type.LIST, "DISTANCE"),
																		new Variable(Type.INTEGER, "distance")
																	}),
																new ModuleFormulaAdaptor() {
																		public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																			return ((astra.lang.Prelude) visitor.agent().getModule("PasswordLengthFinder","prelude")).contains(
																				(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
																				(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
																			);
																	}
																}
																	)
															),
															new Block(
																"PasswordLengthFinder", new int[] {47,62,50,21},
																new Statement[] {
																	new Assignment(
																		new Variable(Type.LIST, "DISTANCE"),
																		"PasswordLengthFinder", new int[] {48,26,50,21},
																		new ModuleTerm("support", Type.LIST,
																			new Predicate("addToAt", new Term[] {
																				new Variable(Type.LIST, "DISTANCE"),
																				Primitive.newPrimitive(0),
																				new Variable(Type.INTEGER, "distance")
																			}),
																			new ModuleTermAdaptor() {
																				public Object invoke(Intention intention, Predicate predicate) {
																					return ((aop.utils.Support) intention.getModule("PasswordLengthFinder","support")).addToAt(
																						(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
																						(java.lang.Integer) intention.evaluate(predicate.getTerm(1)),
																						(java.lang.Integer) intention.evaluate(predicate.getTerm(2))
																					);
																				}
																				public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																					return ((aop.utils.Support) visitor.agent().getModule("PasswordLengthFinder","support")).addToAt(
																						(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
																						(java.lang.Integer) visitor.evaluate(predicate.getTerm(1)),
																						(java.lang.Integer) visitor.evaluate(predicate.getTerm(2))
																					);
																				}
																			}
																		)
																	),
																	new Assignment(
																		new Variable(Type.LIST, "COUNT"),
																		"PasswordLengthFinder", new int[] {49,26,50,21},
																		new ModuleTerm("support", Type.LIST,
																			new Predicate("addToAt", new Term[] {
																				new Variable(Type.LIST, "COUNT"),
																				Primitive.newPrimitive(0),
																				Primitive.newPrimitive(1)
																			}),
																			new ModuleTermAdaptor() {
																				public Object invoke(Intention intention, Predicate predicate) {
																					return ((aop.utils.Support) intention.getModule("PasswordLengthFinder","support")).addToAt(
																						(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
																						(java.lang.Integer) intention.evaluate(predicate.getTerm(1)),
																						(java.lang.Integer) intention.evaluate(predicate.getTerm(2))
																					);
																				}
																				public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																					return ((aop.utils.Support) visitor.agent().getModule("PasswordLengthFinder","support")).addToAt(
																						(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
																						(java.lang.Integer) visitor.evaluate(predicate.getTerm(1)),
																						(java.lang.Integer) visitor.evaluate(predicate.getTerm(2))
																					);
																				}
																			}
																		)
																	)
																}
															),
															new Block(
																"PasswordLengthFinder", new int[] {50,26,63,17},
																new Statement[] {
																	new Declaration(
																		new Variable(Type.INTEGER, "y"),
																		"PasswordLengthFinder", new int[] {51,26,61,21},
																		Primitive.newPrimitive(0)
																	),
																	new While(
																		"PasswordLengthFinder", new int[] {52,26,61,21},
																		new Comparison("<",
																			new Variable(Type.INTEGER, "y"),
																			new ModuleTerm("prelude", Type.INTEGER,
																				new Predicate("size", new Term[] {
																					new Variable(Type.LIST, "DISTANCE")
																				}),
																				new ModuleTermAdaptor() {
																					public Object invoke(Intention intention, Predicate predicate) {
																						return ((astra.lang.Prelude) intention.getModule("PasswordLengthFinder","prelude")).size(
																							(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
																						);
																					}
																					public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																						return ((astra.lang.Prelude) visitor.agent().getModule("PasswordLengthFinder","prelude")).size(
																							(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
																						);
																					}
																				}
																			)
																		),
																		new Block(
																			"PasswordLengthFinder", new int[] {52,61,60,27},
																			new Statement[] {
																				new If(
																					"PasswordLengthFinder", new int[] {53,32,60,27},
																					new Comparison("==",
																						new ModuleTerm("prelude", Type.INTEGER,
																							new Predicate("valueAsInt", new Term[] {
																								new Variable(Type.LIST, "DISTANCE"),
																								new Variable(Type.INTEGER, "y")
																							}),
																							new ModuleTermAdaptor() {
																								public Object invoke(Intention intention, Predicate predicate) {
																									return ((astra.lang.Prelude) intention.getModule("PasswordLengthFinder","prelude")).valueAsInt(
																										(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
																										(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
																									);
																								}
																								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																									return ((astra.lang.Prelude) visitor.agent().getModule("PasswordLengthFinder","prelude")).valueAsInt(
																										(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
																										(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
																									);
																								}
																							}
																						),
																						new Variable(Type.INTEGER, "distance")
																					),
																					new Block(
																						"PasswordLengthFinder", new int[] {53,81,58,33},
																						new Statement[] {
																							new Declaration(
																								new Variable(Type.INTEGER, "temp"),
																								"PasswordLengthFinder", new int[] {54,35,58,33},
																								new ModuleTerm("prelude", Type.INTEGER,
																									new Predicate("valueAsInt", new Term[] {
																										new Variable(Type.LIST, "COUNT"),
																										new Variable(Type.INTEGER, "y")
																									}),
																									new ModuleTermAdaptor() {
																										public Object invoke(Intention intention, Predicate predicate) {
																											return ((astra.lang.Prelude) intention.getModule("PasswordLengthFinder","prelude")).valueAsInt(
																												(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
																												(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
																											);
																										}
																										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																											return ((astra.lang.Prelude) visitor.agent().getModule("PasswordLengthFinder","prelude")).valueAsInt(
																												(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
																												(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
																											);
																										}
																									}
																								)
																							),
																							new Declaration(
																								new Variable(Type.BOOLEAN, "done"),
																								"PasswordLengthFinder", new int[] {56,35,58,33},
																								new ModuleTerm("prelude", Type.BOOLEAN,
																									new Predicate("remove", new Term[] {
																										new Variable(Type.LIST, "COUNT"),
																										new Variable(Type.INTEGER, "y")
																									}),
																									new ModuleTermAdaptor() {
																										public Object invoke(Intention intention, Predicate predicate) {
																											return ((astra.lang.Prelude) intention.getModule("PasswordLengthFinder","prelude")).remove(
																												(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
																												(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
																											);
																										}
																										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																											return ((astra.lang.Prelude) visitor.agent().getModule("PasswordLengthFinder","prelude")).remove(
																												(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
																												(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
																											);
																										}
																									}
																								)
																							),
																							new Assignment(
																								new Variable(Type.LIST, "COUNT"),
																								"PasswordLengthFinder", new int[] {57,35,58,33},
																								new ModuleTerm("support", Type.LIST,
																									new Predicate("addToAt", new Term[] {
																										new Variable(Type.LIST, "COUNT"),
																										new Variable(Type.INTEGER, "y"),
																										Operator.newOperator('+',
																											new Variable(Type.INTEGER, "temp"),
																											Primitive.newPrimitive(1)
																										)
																									}),
																									new ModuleTermAdaptor() {
																										public Object invoke(Intention intention, Predicate predicate) {
																											return ((aop.utils.Support) intention.getModule("PasswordLengthFinder","support")).addToAt(
																												(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
																												(java.lang.Integer) intention.evaluate(predicate.getTerm(1)),
																												(java.lang.Integer) intention.evaluate(predicate.getTerm(2))
																											);
																										}
																										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																											return ((aop.utils.Support) visitor.agent().getModule("PasswordLengthFinder","support")).addToAt(
																												(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
																												(java.lang.Integer) visitor.evaluate(predicate.getTerm(1)),
																												(java.lang.Integer) visitor.evaluate(predicate.getTerm(2))
																											);
																										}
																									}
																								)
																							)
																						}
																					)
																				),
																				new Assignment(
																					new Variable(Type.INTEGER, "y"),
																					"PasswordLengthFinder", new int[] {59,32,60,27},
																					Operator.newOperator('+',
																						new Variable(Type.INTEGER, "y"),
																						Primitive.newPrimitive(1)
																					)
																				)
																			}
																		)
																	)
																}
															)
														),
														new Assignment(
															new Variable(Type.INTEGER, "distance"),
															"PasswordLengthFinder", new int[] {62,20,63,17},
															Primitive.newPrimitive(1)
														)
													}
												),
												new Block(
													"PasswordLengthFinder", new int[] {63,23,67,13},
													new Statement[] {
														new Assignment(
															new Variable(Type.INTEGER, "distance"),
															"PasswordLengthFinder", new int[] {64,20,65,17},
															Operator.newOperator('+',
																new Variable(Type.INTEGER, "distance"),
																Primitive.newPrimitive(1)
															)
														)
													}
												)
											),
											new Assignment(
												new Variable(Type.INTEGER, "x"),
												"PasswordLengthFinder", new int[] {66,16,67,13},
												Operator.newOperator('+',
													new Variable(Type.INTEGER, "x"),
													Primitive.newPrimitive(1)
												)
											)
										}
									)
								),
								new Assignment(
									new Variable(Type.INTEGER, "i"),
									"PasswordLengthFinder", new int[] {68,12,69,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "i"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "S"),
						"PasswordLengthFinder", new int[] {71,8,83,5},
						Primitive.newPrimitive(0)
					),
					new Declaration(
						new Variable(Type.INTEGER, "MAX"),
						"PasswordLengthFinder", new int[] {72,8,83,5},
						Primitive.newPrimitive(0)
					),
					new Declaration(
						new Variable(Type.INTEGER, "PASSWORD_LENGTH"),
						"PasswordLengthFinder", new int[] {73,8,83,5},
						Primitive.newPrimitive(0)
					),
					new While(
						"PasswordLengthFinder", new int[] {74,8,83,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "S"),
							new ModuleTerm("prelude", Type.INTEGER,
								new Predicate("size", new Term[] {
									new Variable(Type.LIST, "COUNT")
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Prelude) intention.getModule("PasswordLengthFinder","prelude")).size(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Prelude) visitor.agent().getModule("PasswordLengthFinder","prelude")).size(
											(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							)
						),
						new Block(
							"PasswordLengthFinder", new int[] {74,40,80,9},
							new Statement[] {
								new If(
									"PasswordLengthFinder", new int[] {75,14,80,9},
									new Comparison(">",
										new ModuleTerm("prelude", Type.INTEGER,
											new Predicate("valueAsInt", new Term[] {
												new Variable(Type.LIST, "COUNT"),
												new Variable(Type.INTEGER, "S")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.Prelude) intention.getModule("PasswordLengthFinder","prelude")).valueAsInt(
														(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
														(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Prelude) visitor.agent().getModule("PasswordLengthFinder","prelude")).valueAsInt(
														(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
														(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
													);
												}
											}
										),
										new Variable(Type.INTEGER, "MAX")
									),
									new Block(
										"PasswordLengthFinder", new int[] {75,54,78,15},
										new Statement[] {
											new Assignment(
												new Variable(Type.INTEGER, "MAX"),
												"PasswordLengthFinder", new int[] {76,17,78,15},
												new ModuleTerm("prelude", Type.INTEGER,
													new Predicate("valueAsInt", new Term[] {
														new Variable(Type.LIST, "COUNT"),
														new Variable(Type.INTEGER, "S")
													}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((astra.lang.Prelude) intention.getModule("PasswordLengthFinder","prelude")).valueAsInt(
																(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
																(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.Prelude) visitor.agent().getModule("PasswordLengthFinder","prelude")).valueAsInt(
																(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
																(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
															);
														}
													}
												)
											),
											new Assignment(
												new Variable(Type.INTEGER, "PASSWORD_LENGTH"),
												"PasswordLengthFinder", new int[] {77,17,78,15},
												new ModuleTerm("prelude", Type.INTEGER,
													new Predicate("valueAsInt", new Term[] {
														new Variable(Type.LIST, "DISTANCE"),
														new Variable(Type.INTEGER, "S")
													}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((astra.lang.Prelude) intention.getModule("PasswordLengthFinder","prelude")).valueAsInt(
																(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
																(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.Prelude) visitor.agent().getModule("PasswordLengthFinder","prelude")).valueAsInt(
																(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
																(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
															);
														}
													}
												)
											)
										}
									)
								),
								new Assignment(
									new Variable(Type.INTEGER, "S"),
									"PasswordLengthFinder", new int[] {79,8,80,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "S"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new Subgoal(
						"PasswordLengthFinder", new int[] {82,8,83,5},
						new Goal(
							new Predicate("doInform", new Term[] {
								new Variable(Type.INTEGER, "PASSWORD_LENGTH"),
								new Variable(Type.STRING, "C")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"PasswordLengthFinder", new int[] {85,9,85,38},
			new GoalEvent('+',
				new Goal(
					new Predicate("doInform", new Term[] {
						new Variable(Type.INTEGER, "L",false),
						new Variable(Type.STRING, "C",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"PasswordLengthFinder", new int[] {85,37,87,5},
				new Statement[] {
					new Send("PasswordLengthFinder", new int[] {86,8,86,43},
						new Performative("inform"),
						Primitive.newPrimitive("cracker"),
						new Predicate("done", new Term[] {
							new Variable(Type.INTEGER, "L"),
							new Variable(Type.STRING, "C")
						})
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("cracker", new Term[] {
				Primitive.newPrimitive("cracker")
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
		fragment.addModule("support",aop.utils.Support.class,agent);
		fragment.addModule("strs",astra.lang.Strings.class,agent);
		fragment.addModule("prelude",astra.lang.Prelude.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new BasicSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new PasswordLengthFinder().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
