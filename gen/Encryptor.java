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


public class Encryptor extends ASTRAClass {
	public Encryptor() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Encryptor", new int[] {17,9,17,95},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "Manager",false),
				new Predicate("taskEncrypt", new Term[] {
					new Variable(Type.STRING, "P",false),
					new Variable(Type.STRING, "T",false)
				})
			),
			new Predicate("manager", new Term[] {
				new Variable(Type.STRING, "Manager")
			}),
			new Block(
				"Encryptor", new int[] {17,94,29,5},
				new Statement[] {
					new If(
						"Encryptor", new int[] {18,9,29,5},
						new OR(
							new Comparison("==",
								new Variable(Type.STRING, "P"),
								Primitive.newPrimitive("")
							),
							new Comparison("==",
								new Variable(Type.STRING, "T"),
								Primitive.newPrimitive("")
							)
						),
						new Block(
							"Encryptor", new int[] {18,31,20,10},
							new Statement[] {
								new Send("Encryptor", new int[] {19,12,19,79},
									new Performative("refuse"),
									new Variable(Type.STRING, "Manager"),
									new Predicate("state", new Term[] {
										Operator.newOperator('+',
											new ModuleTerm("system", Type.STRING,
												new Predicate("name", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Encryptor","system")).name(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.System) visitor.agent().getModule("Encryptor","system")).name(
														);
													}
												}
											),
											Primitive.newPrimitive(" refused to encrypt")
										)
									})
								)
							}
						),
						new Block(
							"Encryptor", new int[] {20,16,29,5},
							new Statement[] {
								new Send("Encryptor", new int[] {21,12,21,77},
									new Performative("agree"),
									new Variable(Type.STRING, "Manager"),
									new Predicate("state", new Term[] {
										Operator.newOperator('+',
											new ModuleTerm("system", Type.STRING,
												new Predicate("name", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Encryptor","system")).name(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.System) visitor.agent().getModule("Encryptor","system")).name(
														);
													}
												}
											),
											Primitive.newPrimitive(" agreed to encrypt")
										)
									})
								),
								new TryRecover(
									"Encryptor", new int[] {23,12,28,9},
									new Block(
										"Encryptor", new int[] {23,16,25,13},
										new Statement[] {
											new Subgoal(
												"Encryptor", new int[] {24,16,25,13},
												new Goal(
													new Predicate("doEncrypt", new Term[] {
														new Variable(Type.STRING, "P"),
														new Variable(Type.STRING, "T")
													})
												)
											)
										}
									),
									new Block(
										"Encryptor", new int[] {25,22,28,9},
										new Statement[] {
											new Send("Encryptor", new int[] {26,16,26,82},
												new Performative("failure"),
												new Variable(Type.STRING, "Manager"),
												new Predicate("state", new Term[] {
													Operator.newOperator('+',
														new ModuleTerm("system", Type.STRING,
															new Predicate("name", new Term[] {}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((astra.lang.System) intention.getModule("Encryptor","system")).name(
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((astra.lang.System) visitor.agent().getModule("Encryptor","system")).name(
																	);
																}
															}
														),
														Primitive.newPrimitive(" fails to encrypt")
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
			"Encryptor", new int[] {31,9,31,42},
			new GoalEvent('+',
				new Goal(
					new Predicate("doEncrypt", new Term[] {
						new Variable(Type.STRING, "P",false),
						new Variable(Type.STRING, "T",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Encryptor", new int[] {31,41,48,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "longKey"),
						"Encryptor", new int[] {32,8,48,5},
						Operator.newOperator('+',
							new Variable(Type.STRING, "P"),
							new ModuleTerm("support", Type.STRING,
								new Predicate("substring", new Term[] {
									new Variable(Type.STRING, "T"),
									Primitive.newPrimitive(0),
									Operator.newOperator('-',
										new ModuleTerm("support", Type.INTEGER,
											new Predicate("length", new Term[] {
												new Variable(Type.STRING, "T")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((aop.utils.Support) intention.getModule("Encryptor","support")).length(
														(java.lang.String) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((aop.utils.Support) visitor.agent().getModule("Encryptor","support")).length(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0))
													);
												}
											}
										),
										new ModuleTerm("support", Type.INTEGER,
											new Predicate("length", new Term[] {
												new Variable(Type.STRING, "P")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((aop.utils.Support) intention.getModule("Encryptor","support")).length(
														(java.lang.String) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((aop.utils.Support) visitor.agent().getModule("Encryptor","support")).length(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0))
													);
												}
											}
										)
									)
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((aop.utils.Support) intention.getModule("Encryptor","support")).substring(
											(java.lang.String) intention.evaluate(predicate.getTerm(0)),
											(java.lang.Integer) intention.evaluate(predicate.getTerm(1)),
											(java.lang.Integer) intention.evaluate(predicate.getTerm(2))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((aop.utils.Support) visitor.agent().getModule("Encryptor","support")).substring(
											(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
											(java.lang.Integer) visitor.evaluate(predicate.getTerm(1)),
											(java.lang.Integer) visitor.evaluate(predicate.getTerm(2))
										);
									}
								}
							)
						)
					),
					new Declaration(
						new Variable(Type.STRING, "sb"),
						"Encryptor", new int[] {33,8,48,5},
						Primitive.newPrimitive("")
					),
					new Declaration(
						new Variable(Type.INTEGER, "i"),
						"Encryptor", new int[] {34,8,48,5},
						Primitive.newPrimitive(0)
					),
					new While(
						"Encryptor", new int[] {35,8,48,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "i"),
							new ModuleTerm("support", Type.INTEGER,
								new Predicate("length", new Term[] {
									new Variable(Type.STRING, "T")
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((aop.utils.Support) intention.getModule("Encryptor","support")).length(
											(java.lang.String) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((aop.utils.Support) visitor.agent().getModule("Encryptor","support")).length(
											(java.lang.String) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							)
						),
						new Block(
							"Encryptor", new int[] {35,39,46,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "c"),
									"Encryptor", new int[] {36,12,46,9},
									new ModuleTerm("support", Type.INTEGER,
										new Predicate("charAt", new Term[] {
											new Variable(Type.STRING, "T"),
											new Variable(Type.INTEGER, "i")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((aop.utils.Support) intention.getModule("Encryptor","support")).charAt(
													(java.lang.String) intention.evaluate(predicate.getTerm(0)),
													(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((aop.utils.Support) visitor.agent().getModule("Encryptor","support")).charAt(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
												);
											}
										}
									)
								),
								new If(
									"Encryptor", new int[] {37,12,46,9},
									new Comparison(">=",
										new Variable(Type.INTEGER, "c"),
										Primitive.newPrimitive(32)
									),
									new Block(
										"Encryptor", new int[] {37,24,43,13},
										new Statement[] {
											new Declaration(
												new Variable(Type.INTEGER, "keyCharValue"),
												"Encryptor", new int[] {38,16,43,13},
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
																			return ((aop.utils.Support) intention.getModule("Encryptor","support")).length(
																				(java.lang.String) intention.evaluate(predicate.getTerm(0))
																			);
																		}
																		public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																			return ((aop.utils.Support) visitor.agent().getModule("Encryptor","support")).length(
																				(java.lang.String) visitor.evaluate(predicate.getTerm(0))
																			);
																		}
																	}
																)
															)
														}),
														new ModuleTermAdaptor() {
															public Object invoke(Intention intention, Predicate predicate) {
																return ((aop.utils.Support) intention.getModule("Encryptor","support")).charAt(
																	(java.lang.String) intention.evaluate(predicate.getTerm(0)),
																	(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
																);
															}
															public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																return ((aop.utils.Support) visitor.agent().getModule("Encryptor","support")).charAt(
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
												"Encryptor", new int[] {39,16,43,13},
												Operator.newOperator('+',
													new Variable(Type.INTEGER, "c"),
													new Variable(Type.INTEGER, "keyCharValue")
												)
											),
											new If(
												"Encryptor", new int[] {40,16,43,13},
												new Comparison(">",
													new Variable(Type.INTEGER, "c"),
													Primitive.newPrimitive(127)
												),
												new Block(
													"Encryptor", new int[] {40,28,42,17},
													new Statement[] {
														new Assignment(
															new Variable(Type.INTEGER, "c"),
															"Encryptor", new int[] {41,20,42,17},
															Operator.newOperator('+',
																new Variable(Type.INTEGER, "c"),
																Operator.newOperator('-',
																	Primitive.newPrimitive(32),
																	Primitive.newPrimitive(127)
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
									"Encryptor", new int[] {44,12,46,9},
									Operator.newOperator('+',
										new Variable(Type.STRING, "sb"),
										new ModuleTerm("support", Type.CHAR,
											new Predicate("toChar", new Term[] {
												new Variable(Type.INTEGER, "c")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((aop.utils.Support) intention.getModule("Encryptor","support")).toChar(
														(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((aop.utils.Support) visitor.agent().getModule("Encryptor","support")).toChar(
														(java.lang.Integer) visitor.evaluate(predicate.getTerm(0))
													);
												}
											}
										)
									)
								),
								new Assignment(
									new Variable(Type.INTEGER, "i"),
									"Encryptor", new int[] {45,12,46,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "i"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new Subgoal(
						"Encryptor", new int[] {47,8,48,5},
						new Goal(
							new Predicate("doInform", new Term[] {
								new Variable(Type.STRING, "sb")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Encryptor", new int[] {50,9,50,31},
			new GoalEvent('+',
				new Goal(
					new Predicate("doInform", new Term[] {
						new Variable(Type.STRING, "C",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Encryptor", new int[] {50,30,52,5},
				new Statement[] {
					new Send("Encryptor", new int[] {51,8,51,48},
						new Performative("inform"),
						new ModuleTerm("system", Type.STRING,
							new Predicate("getOwner", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.System) intention.getModule("Encryptor","system")).getOwner(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.System) visitor.agent().getModule("Encryptor","system")).getOwner(
									);
								}
							}
						),
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
			astra.core.Agent agent = new Encryptor().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
