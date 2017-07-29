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


public class Cracker extends ASTRAClass {
	public Cracker() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Cracker", new int[] {24,9,24,83},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "Manager",false),
				new Predicate("taskCrack", new Term[] {
					new Variable(Type.STRING, "C",false)
				})
			),
			new Predicate("manager", new Term[] {
				new Variable(Type.STRING, "Manager")
			}),
			new Block(
				"Cracker", new int[] {24,82,38,5},
				new Statement[] {
					new If(
						"Cracker", new int[] {26,9,38,5},
						new Comparison("==",
							new Variable(Type.STRING, "C"),
							Primitive.newPrimitive("")
						),
						new Block(
							"Cracker", new int[] {26,21,28,10},
							new Statement[] {
								new Send("Cracker", new int[] {27,12,27,77},
									new Performative("refuse"),
									new Variable(Type.STRING, "Manager"),
									new Predicate("state", new Term[] {
										Operator.newOperator('+',
											new ModuleTerm("system", Type.STRING,
												new Predicate("name", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Cracker","system")).name(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.System) visitor.agent().getModule("Cracker","system")).name(
														);
													}
												}
											),
											Primitive.newPrimitive(" refused to crack")
										)
									})
								)
							}
						),
						new Block(
							"Cracker", new int[] {28,16,38,5},
							new Statement[] {
								new Send("Cracker", new int[] {29,12,29,75},
									new Performative("agree"),
									new Variable(Type.STRING, "Manager"),
									new Predicate("state", new Term[] {
										Operator.newOperator('+',
											new ModuleTerm("system", Type.STRING,
												new Predicate("name", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Cracker","system")).name(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.System) visitor.agent().getModule("Cracker","system")).name(
														);
													}
												}
											),
											Primitive.newPrimitive(" agreed to crack")
										)
									})
								),
								new TryRecover(
									"Cracker", new int[] {31,12,37,9},
									new Block(
										"Cracker", new int[] {31,16,34,13},
										new Statement[] {
											new ModuleCall("system",
												"Cracker", new int[] {32,16,32,82},
												new Predicate("createAgent", new Term[] {
													Primitive.newPrimitive("passwordLengthFinder"),
													Primitive.newPrimitive("PasswordLengthFinder")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return false;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Cracker","system")).createAgent(
															(java.lang.String) intention.evaluate(predicate.getTerm(0)),
															(java.lang.String) intention.evaluate(predicate.getTerm(1))
														);
													}
												}
											),
											new Subgoal(
												"Cracker", new int[] {33,16,34,13},
												new Goal(
													new Predicate("doPasswordLength", new Term[] {
														new Variable(Type.STRING, "C")
													})
												)
											)
										}
									),
									new Block(
										"Cracker", new int[] {34,22,37,9},
										new Statement[] {
											new Send("Cracker", new int[] {35,16,35,80},
												new Performative("failure"),
												new Variable(Type.STRING, "Manager"),
												new Predicate("state", new Term[] {
													Operator.newOperator('+',
														new ModuleTerm("system", Type.STRING,
															new Predicate("name", new Term[] {}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((astra.lang.System) intention.getModule("Cracker","system")).name(
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((astra.lang.System) visitor.agent().getModule("Cracker","system")).name(
																	);
																}
															}
														),
														Primitive.newPrimitive(" fails to crack")
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
			"Cracker", new int[] {40,9,40,73},
			new GoalEvent('+',
				new Goal(
					new Predicate("doPasswordLength", new Term[] {
						new Variable(Type.STRING, "C",false)
					})
				)
			),
			new Predicate("passwordLengthFinder", new Term[] {
				new Variable(Type.STRING, "PLF",false)
			}),
			new Block(
				"Cracker", new int[] {40,72,43,5},
				new Statement[] {
					new Send("Cracker", new int[] {42,9,42,50},
						new Performative("request"),
						new Variable(Type.STRING, "PLF"),
						new Predicate("taskPasswordLength", new Term[] {
							new Variable(Type.STRING, "C")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Cracker", new int[] {45,9,45,67},
			new GoalEvent('+',
				new Goal(
					new Predicate("doPassword", new Term[] {
						new Variable(Type.STRING, "C",false),
						new Variable(Type.INTEGER, "L",false)
					})
				)
			),
			new Predicate("passwordFinder", new Term[] {
				new Variable(Type.STRING, "PF",false)
			}),
			new Block(
				"Cracker", new int[] {45,66,48,5},
				new Statement[] {
					new Send("Cracker", new int[] {47,8,47,45},
						new Performative("request"),
						new Variable(Type.STRING, "PF"),
						new Predicate("taskPassword", new Term[] {
							new Variable(Type.STRING, "C"),
							new Variable(Type.INTEGER, "L")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Cracker", new int[] {50,9,50,107},
			new MessageEvent(
				new Performative("agree"),
				new Variable(Type.STRING, "From",false),
				new Predicate("state", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			new OR(
				new Predicate("passwordLengthFinder", new Term[] {
					new Variable(Type.STRING, "From")
				}),
				new Predicate("passwordFinder", new Term[] {
					new Variable(Type.STRING, "From")
				})
			),
			new Block(
				"Cracker", new int[] {50,106,52,5},
				new Statement[] {
					new Send("Cracker", new int[] {51,8,51,49},
						new Performative("inform"),
						new ModuleTerm("system", Type.STRING,
							new Predicate("getOwner", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.System) intention.getModule("Cracker","system")).getOwner(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.System) visitor.agent().getModule("Cracker","system")).getOwner(
									);
								}
							}
						),
						new Predicate("state", new Term[] {
							new Variable(Type.STRING, "S")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Cracker", new int[] {54,9,54,108},
			new MessageEvent(
				new Performative("refuse"),
				new Variable(Type.STRING, "From",false),
				new Predicate("state", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			new OR(
				new Predicate("passwordLengthFinder", new Term[] {
					new Variable(Type.STRING, "From")
				}),
				new Predicate("passwordFinder", new Term[] {
					new Variable(Type.STRING, "From")
				})
			),
			new Block(
				"Cracker", new int[] {54,107,58,5},
				new Statement[] {
					new ModuleCall("system",
						"Cracker", new int[] {55,8,55,35},
						new Predicate("terminateAgent", new Term[] {
							new Variable(Type.STRING, "From")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Cracker","system")).terminateAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Send("Cracker", new int[] {56,8,56,51},
						new Performative("inform"),
						new ModuleTerm("system", Type.STRING,
							new Predicate("getOwner", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.System) intention.getModule("Cracker","system")).getOwner(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.System) visitor.agent().getModule("Cracker","system")).getOwner(
									);
								}
							}
						),
						new Predicate("problem", new Term[] {
							new Variable(Type.STRING, "S")
						})
					),
					new ModuleCall("console",
						"Cracker", new int[] {57,8,57,41},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.STRING, "From"),
								Operator.newOperator('+',
									Primitive.newPrimitive(" : "),
									new Variable(Type.STRING, "S")
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Cracker","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Cracker", new int[] {60,9,60,109},
			new MessageEvent(
				new Performative("failure"),
				new Variable(Type.STRING, "From",false),
				new Predicate("state", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			new OR(
				new Predicate("passwordLengthFinder", new Term[] {
					new Variable(Type.STRING, "From")
				}),
				new Predicate("passwordFinder", new Term[] {
					new Variable(Type.STRING, "From")
				})
			),
			new Block(
				"Cracker", new int[] {60,108,63,5},
				new Statement[] {
					new ModuleCall("system",
						"Cracker", new int[] {61,8,61,35},
						new Predicate("terminateAgent", new Term[] {
							new Variable(Type.STRING, "From")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Cracker","system")).terminateAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Send("Cracker", new int[] {62,8,62,51},
						new Performative("inform"),
						new ModuleTerm("system", Type.STRING,
							new Predicate("getOwner", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.System) intention.getModule("Cracker","system")).getOwner(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.System) visitor.agent().getModule("Cracker","system")).getOwner(
									);
								}
							}
						),
						new Predicate("problem", new Term[] {
							new Variable(Type.STRING, "S")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Cracker", new int[] {65,9,65,89},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "PLF",false),
				new Predicate("done", new Term[] {
					new Variable(Type.INTEGER, "L",false),
					new Variable(Type.STRING, "C",false)
				})
			),
			new Predicate("passwordLengthFinder", new Term[] {
				new Variable(Type.STRING, "PLF")
			}),
			new Block(
				"Cracker", new int[] {65,88,70,5},
				new Statement[] {
					new ModuleCall("system",
						"Cracker", new int[] {66,8,66,34},
						new Predicate("terminateAgent", new Term[] {
							new Variable(Type.STRING, "PLF")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Cracker","system")).terminateAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Send("Cracker", new int[] {67,8,67,48},
						new Performative("inform"),
						new ModuleTerm("system", Type.STRING,
							new Predicate("getOwner", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.System) intention.getModule("Cracker","system")).getOwner(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.System) visitor.agent().getModule("Cracker","system")).getOwner(
									);
								}
							}
						),
						new Predicate("done", new Term[] {
							new Variable(Type.INTEGER, "L")
						})
					),
					new ModuleCall("system",
						"Cracker", new int[] {68,8,68,62},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("passwordFinder"),
							Primitive.newPrimitive("PasswordFinder")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Cracker","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new Subgoal(
						"Cracker", new int[] {69,8,70,5},
						new Goal(
							new Predicate("doPassword", new Term[] {
								new Variable(Type.STRING, "C"),
								new Variable(Type.INTEGER, "L")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Cracker", new int[] {72,9,72,84},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "PF",false),
				new Predicate("done", new Term[] {
					new Variable(Type.STRING, "P",false),
					new Variable(Type.STRING, "C",false)
				})
			),
			new Predicate("passwordFinder", new Term[] {
				new Variable(Type.STRING, "PF")
			}),
			new Block(
				"Cracker", new int[] {72,83,75,5},
				new Statement[] {
					new ModuleCall("system",
						"Cracker", new int[] {73,8,73,33},
						new Predicate("terminateAgent", new Term[] {
							new Variable(Type.STRING, "PF")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Cracker","system")).terminateAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Send("Cracker", new int[] {74,8,74,51},
						new Performative("inform"),
						new ModuleTerm("system", Type.STRING,
							new Predicate("getOwner", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.System) intention.getModule("Cracker","system")).getOwner(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.System) visitor.agent().getModule("Cracker","system")).getOwner(
									);
								}
							}
						),
						new Predicate("done", new Term[] {
							new Variable(Type.STRING, "P"),
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
		agent.initialize(
			new Predicate("passwordLengthFinder", new Term[] {
				Primitive.newPrimitive("passwordLengthFinder")
			})
		);
		agent.initialize(
			new Predicate("passwordFinder", new Term[] {
				Primitive.newPrimitive("passwordFinder")
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
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
			astra.core.Agent agent = new Cracker().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
