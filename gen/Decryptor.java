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


public class Decryptor extends ASTRAClass {
	public Decryptor() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Decryptor", new int[] {19,9,19,95},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "Manager",false),
				new Predicate("taskDecrypt", new Term[] {
					new Variable(Type.STRING, "P",false),
					new Variable(Type.STRING, "C",false)
				})
			),
			new Predicate("manager", new Term[] {
				new Variable(Type.STRING, "Manager")
			}),
			new Block(
				"Decryptor", new int[] {19,94,31,5},
				new Statement[] {
					new If(
						"Decryptor", new int[] {20,9,31,5},
						new OR(
							new Comparison("==",
								new Variable(Type.STRING, "P"),
								Primitive.newPrimitive("")
							),
							new Comparison("==",
								new Variable(Type.STRING, "C"),
								Primitive.newPrimitive("")
							)
						),
						new Block(
							"Decryptor", new int[] {20,31,22,10},
							new Statement[] {
								new Send("Decryptor", new int[] {21,12,21,79},
									new Performative("refuse"),
									new Variable(Type.STRING, "Manager"),
									new Predicate("state", new Term[] {
										Operator.newOperator('+',
											new ModuleTerm("system", Type.STRING,
												new Predicate("name", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Decryptor","system")).name(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.System) visitor.agent().getModule("Decryptor","system")).name(
														);
													}
												}
											),
											Primitive.newPrimitive(" refused to decrypt")
										)
									})
								)
							}
						),
						new Block(
							"Decryptor", new int[] {22,16,31,5},
							new Statement[] {
								new Send("Decryptor", new int[] {23,12,23,77},
									new Performative("agree"),
									new Variable(Type.STRING, "Manager"),
									new Predicate("state", new Term[] {
										Operator.newOperator('+',
											new ModuleTerm("system", Type.STRING,
												new Predicate("name", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Decryptor","system")).name(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.System) visitor.agent().getModule("Decryptor","system")).name(
														);
													}
												}
											),
											Primitive.newPrimitive(" agreed to decrypt")
										)
									})
								),
								new TryRecover(
									"Decryptor", new int[] {25,12,30,9},
									new Block(
										"Decryptor", new int[] {25,16,27,13},
										new Statement[] {
											new Subgoal(
												"Decryptor", new int[] {26,17,27,13},
												new Goal(
													new Predicate("doDecrypt", new Term[] {
														new Variable(Type.STRING, "P"),
														new Variable(Type.STRING, "C"),
														new Variable(Type.STRING, "Manager")
													})
												)
											)
										}
									),
									new Block(
										"Decryptor", new int[] {27,22,30,9},
										new Statement[] {
											new Send("Decryptor", new int[] {28,16,28,82},
												new Performative("failure"),
												new Variable(Type.STRING, "Manager"),
												new Predicate("state", new Term[] {
													Operator.newOperator('+',
														new ModuleTerm("system", Type.STRING,
															new Predicate("name", new Term[] {}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((astra.lang.System) intention.getModule("Decryptor","system")).name(
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((astra.lang.System) visitor.agent().getModule("Decryptor","system")).name(
																	);
																}
															}
														),
														Primitive.newPrimitive(" fails to decrypt")
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
			"Decryptor", new int[] {33,9,33,58},
			new GoalEvent('+',
				new Goal(
					new Predicate("doDecrypt", new Term[] {
						new Variable(Type.STRING, "P",false),
						new Variable(Type.STRING, "C",false),
						new Variable(Type.STRING, "Manager",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Decryptor", new int[] {33,57,57,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "longKey"),
						"Decryptor", new int[] {34,8,57,5},
						new Variable(Type.STRING, "P")
					),
					new Declaration(
						new Variable(Type.STRING, "sb"),
						"Decryptor", new int[] {35,8,57,5},
						Primitive.newPrimitive("")
					),
					new Declaration(
						new Variable(Type.INTEGER, "i"),
						"Decryptor", new int[] {36,8,57,5},
						Primitive.newPrimitive(0)
					),
					new While(
						"Decryptor", new int[] {37,8,57,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "i"),
							new ModuleTerm("support", Type.INTEGER,
								new Predicate("length", new Term[] {
									new Variable(Type.STRING, "C")
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((aop.utils.Support) intention.getModule("Decryptor","support")).length(
											(java.lang.String) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((aop.utils.Support) visitor.agent().getModule("Decryptor","support")).length(
											(java.lang.String) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							)
						),
						new Block(
							"Decryptor", new int[] {37,38,54,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "c"),
									"Decryptor", new int[] {39,12,54,9},
									new ModuleTerm("support", Type.INTEGER,
										new Predicate("charAt", new Term[] {
											new Variable(Type.STRING, "C"),
											new Variable(Type.INTEGER, "i")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((aop.utils.Support) intention.getModule("Decryptor","support")).charAt(
													(java.lang.String) intention.evaluate(predicate.getTerm(0)),
													(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((aop.utils.Support) visitor.agent().getModule("Decryptor","support")).charAt(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
												);
											}
										}
									)
								),
								new If(
									"Decryptor", new int[] {40,12,54,9},
									new Comparison(">",
										new Variable(Type.INTEGER, "i"),
										Operator.newOperator('-',
											new ModuleTerm("support", Type.INTEGER,
												new Predicate("length", new Term[] {
													new Variable(Type.STRING, "P")
												}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((aop.utils.Support) intention.getModule("Decryptor","support")).length(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((aop.utils.Support) visitor.agent().getModule("Decryptor","support")).length(
															(java.lang.String) visitor.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											Primitive.newPrimitive(1)
										)
									),
									new Block(
										"Decryptor", new int[] {40,42,43,13},
										new Statement[] {
											new Declaration(
												new Variable(Type.STRING, "temp"),
												"Decryptor", new int[] {41,16,43,13},
												new ModuleTerm("support", Type.STRING,
													new Predicate("substring", new Term[] {
														new Variable(Type.STRING, "sb"),
														Operator.newOperator('-',
															new Variable(Type.INTEGER, "i"),
															new ModuleTerm("support", Type.INTEGER,
																new Predicate("length", new Term[] {
																	new Variable(Type.STRING, "P")
																}),
																new ModuleTermAdaptor() {
																	public Object invoke(Intention intention, Predicate predicate) {
																		return ((aop.utils.Support) intention.getModule("Decryptor","support")).length(
																			(java.lang.String) intention.evaluate(predicate.getTerm(0))
																		);
																	}
																	public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																		return ((aop.utils.Support) visitor.agent().getModule("Decryptor","support")).length(
																			(java.lang.String) visitor.evaluate(predicate.getTerm(0))
																		);
																	}
																}
															)
														),
														Operator.newOperator('+',
															Operator.newOperator('-',
																new Variable(Type.INTEGER, "i"),
																new ModuleTerm("support", Type.INTEGER,
																	new Predicate("length", new Term[] {
																		new Variable(Type.STRING, "P")
																	}),
																	new ModuleTermAdaptor() {
																		public Object invoke(Intention intention, Predicate predicate) {
																			return ((aop.utils.Support) intention.getModule("Decryptor","support")).length(
																				(java.lang.String) intention.evaluate(predicate.getTerm(0))
																			);
																		}
																		public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																			return ((aop.utils.Support) visitor.agent().getModule("Decryptor","support")).length(
																				(java.lang.String) visitor.evaluate(predicate.getTerm(0))
																			);
																		}
																	}
																)
															),
															Primitive.newPrimitive(1)
														)
													}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((aop.utils.Support) intention.getModule("Decryptor","support")).substring(
																(java.lang.String) intention.evaluate(predicate.getTerm(0)),
																(java.lang.Integer) intention.evaluate(predicate.getTerm(1)),
																(java.lang.Integer) intention.evaluate(predicate.getTerm(2))
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((aop.utils.Support) visitor.agent().getModule("Decryptor","support")).substring(
																(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																(java.lang.Integer) visitor.evaluate(predicate.getTerm(1)),
																(java.lang.Integer) visitor.evaluate(predicate.getTerm(2))
															);
														}
													}
												)
											),
											new Assignment(
												new Variable(Type.STRING, "longKey"),
												"Decryptor", new int[] {42,16,43,13},
												Operator.newOperator('+',
													new Variable(Type.STRING, "longKey"),
													new Variable(Type.STRING, "temp")
												)
											)
										}
									)
								),
								new If(
									"Decryptor", new int[] {45,12,54,9},
									new Comparison(">=",
										new Variable(Type.INTEGER, "c"),
										Primitive.newPrimitive(32)
									),
									new Block(
										"Decryptor", new int[] {45,24,51,13},
										new Statement[] {
											new Declaration(
												new Variable(Type.INTEGER, "keyCharValue"),
												"Decryptor", new int[] {46,16,51,13},
												Operator.newOperator('-',
													new ModuleTerm("support", Type.INTEGER,
														new Predicate("charAt", new Term[] {
															new Variable(Type.STRING, "longKey"),
															Operator.newOperator('%',
																new Variable(Type.INTEGER, "i"),
																new ModuleTerm("support", Type.INTEGER,
																	new Predicate("length", new Term[] {
																		new Variable(Type.STRING, "longKey")
																	}),
																	new ModuleTermAdaptor() {
																		public Object invoke(Intention intention, Predicate predicate) {
																			return ((aop.utils.Support) intention.getModule("Decryptor","support")).length(
																				(java.lang.String) intention.evaluate(predicate.getTerm(0))
																			);
																		}
																		public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																			return ((aop.utils.Support) visitor.agent().getModule("Decryptor","support")).length(
																				(java.lang.String) visitor.evaluate(predicate.getTerm(0))
																			);
																		}
																	}
																)
															)
														}),
														new ModuleTermAdaptor() {
															public Object invoke(Intention intention, Predicate predicate) {
																return ((aop.utils.Support) intention.getModule("Decryptor","support")).charAt(
																	(java.lang.String) intention.evaluate(predicate.getTerm(0)),
																	(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
																);
															}
															public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																return ((aop.utils.Support) visitor.agent().getModule("Decryptor","support")).charAt(
																	(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																	(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
																);
															}
														}
													),
													Primitive.newPrimitive(65)
												)
											),
											new Assignment(
												new Variable(Type.INTEGER, "c"),
												"Decryptor", new int[] {47,16,51,13},
												Operator.newOperator('-',
													new Variable(Type.INTEGER, "c"),
													new Variable(Type.INTEGER, "keyCharValue")
												)
											),
											new If(
												"Decryptor", new int[] {48,16,51,13},
												new Comparison("<",
													new Variable(Type.INTEGER, "c"),
													Primitive.newPrimitive(32)
												),
												new Block(
													"Decryptor", new int[] {48,27,50,17},
													new Statement[] {
														new Assignment(
															new Variable(Type.INTEGER, "c"),
															"Decryptor", new int[] {49,20,50,17},
															Operator.newOperator('+',
																new Variable(Type.INTEGER, "c"),
																Operator.newOperator('-',
																	Primitive.newPrimitive(127),
																	Primitive.newPrimitive(32)
																)
															)
														)
													}
												)
											)
										}
									)
								),
								new Assignment(
									new Variable(Type.STRING, "sb"),
									"Decryptor", new int[] {52,12,54,9},
									Operator.newOperator('+',
										new Variable(Type.STRING, "sb"),
										new ModuleTerm("support", Type.CHAR,
											new Predicate("toChar", new Term[] {
												new Variable(Type.INTEGER, "c")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((aop.utils.Support) intention.getModule("Decryptor","support")).toChar(
														(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((aop.utils.Support) visitor.agent().getModule("Decryptor","support")).toChar(
														(java.lang.Integer) visitor.evaluate(predicate.getTerm(0))
													);
												}
											}
										)
									)
								),
								new Assignment(
									new Variable(Type.INTEGER, "i"),
									"Decryptor", new int[] {53,12,54,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "i"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new Subgoal(
						"Decryptor", new int[] {56,8,57,5},
						new Goal(
							new Predicate("doInform", new Term[] {
								new Variable(Type.STRING, "sb"),
								new Variable(Type.STRING, "Manager")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Decryptor", new int[] {59,9,59,47},
			new GoalEvent('+',
				new Goal(
					new Predicate("doInform", new Term[] {
						new Variable(Type.STRING, "C",false),
						new Variable(Type.STRING, "Manager",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Decryptor", new int[] {59,46,61,5},
				new Statement[] {
					new Send("Decryptor", new int[] {60,8,60,38},
						new Performative("inform"),
						new Variable(Type.STRING, "Manager"),
						new Predicate("done", new Term[] {
							new Variable(Type.STRING, "C")
						})
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("manager", new Term[] {
				Primitive.newPrimitive("main")
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
		fragment.addModule("support",aop.utils.Support.class,agent);
		fragment.addModule("strs",astra.lang.Strings.class,agent);
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
			astra.core.Agent agent = new Decryptor().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
