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


public class Manager extends ASTRAClass {
	public Manager() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Manager", new int[] {26,9,26,19},
			new GoalEvent('+',
				new Goal(
					new Predicate("init", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Manager", new int[] {26,18,28,5},
				new Statement[] {
					new ModuleCall("gui",
						"Manager", new int[] {27,8,27,40},
						new Predicate("launch", new Term[] {
							Primitive.newPrimitive("gui.JFrameVigenere")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((aop.GUIModule) intention.getModule("Manager","gui")).launch(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {30,9,30,57},
			new GoalEvent('+',
				new Goal(
					new Predicate("encrypt", new Term[] {
						new Variable(new ObjectType(aop.PlainObject.class), "plainObject",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Manager", new int[] {30,56,35,5},
				new Statement[] {
					new ModuleCall("system",
						"Manager", new int[] {32,8,32,52},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("encryptor"),
							Primitive.newPrimitive("Encryptor")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Manager","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new Send("Manager", new int[] {34,8,34,108},
						new Performative("request"),
						Primitive.newPrimitive("encryptor"),
						new Predicate("taskEncrypt", new Term[] {
							new ModuleTerm("gui", Type.STRING,
								new Predicate("getPassword", new Term[] {
									new Variable(new ObjectType(aop.PlainObject.class), "plainObject")
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((aop.GUIModule) intention.getModule("Manager","gui")).getPassword(
											(aop.PlainObject) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((aop.GUIModule) visitor.agent().getModule("Manager","gui")).getPassword(
											(aop.PlainObject) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new ModuleTerm("gui", Type.STRING,
								new Predicate("getPlainText", new Term[] {
									new Variable(new ObjectType(aop.PlainObject.class), "plainObject")
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((aop.GUIModule) intention.getModule("Manager","gui")).getPlainText(
											(aop.PlainObject) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((aop.GUIModule) visitor.agent().getModule("Manager","gui")).getPlainText(
											(aop.PlainObject) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							)
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {37,9,37,59},
			new GoalEvent('+',
				new Goal(
					new Predicate("decrypt", new Term[] {
						new Variable(new ObjectType(aop.CipherObject.class), "cipherObject",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Manager", new int[] {37,58,42,5},
				new Statement[] {
					new ModuleCall("system",
						"Manager", new int[] {39,8,39,52},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("decryptor"),
							Primitive.newPrimitive("Decryptor")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Manager","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new Send("Manager", new int[] {41,8,41,111},
						new Performative("request"),
						Primitive.newPrimitive("decryptor"),
						new Predicate("taskDecrypt", new Term[] {
							new ModuleTerm("gui", Type.STRING,
								new Predicate("getPassword", new Term[] {
									new Variable(new ObjectType(aop.CipherObject.class), "cipherObject")
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((aop.GUIModule) intention.getModule("Manager","gui")).getPassword(
											(aop.CipherObject) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((aop.GUIModule) visitor.agent().getModule("Manager","gui")).getPassword(
											(aop.CipherObject) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new ModuleTerm("gui", Type.STRING,
								new Predicate("getCipherText", new Term[] {
									new Variable(new ObjectType(aop.CipherObject.class), "cipherObject")
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((aop.GUIModule) intention.getModule("Manager","gui")).getCipherText(
											(aop.CipherObject) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((aop.GUIModule) visitor.agent().getModule("Manager","gui")).getCipherText(
											(aop.CipherObject) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							)
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {44,9,44,57},
			new GoalEvent('+',
				new Goal(
					new Predicate("crack", new Term[] {
						new Variable(new ObjectType(aop.CipherObject.class), "cipherObject",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Manager", new int[] {44,56,49,5},
				new Statement[] {
					new ModuleCall("system",
						"Manager", new int[] {46,8,46,48},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("cracker"),
							Primitive.newPrimitive("Cracker")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Manager","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new Send("Manager", new int[] {48,8,48,76},
						new Performative("request"),
						Primitive.newPrimitive("cracker"),
						new Predicate("taskCrack", new Term[] {
							new ModuleTerm("gui", Type.STRING,
								new Predicate("getCipherText", new Term[] {
									new Variable(new ObjectType(aop.CipherObject.class), "cipherObject")
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((aop.GUIModule) intention.getModule("Manager","gui")).getCipherText(
											(aop.CipherObject) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((aop.GUIModule) visitor.agent().getModule("Manager","gui")).getCipherText(
											(aop.CipherObject) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							)
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {51,9,51,56},
			new MessageEvent(
				new Performative("agree"),
				new Variable(Type.STRING, "From",false),
				new Predicate("state", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Manager", new int[] {51,55,54,5},
				new Statement[] {
					new ModuleCall("console",
						"Manager", new int[] {52,8,52,41},
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
								return ((astra.lang.Console) intention.getModule("Manager","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Manager", new int[] {53,8,54,5},
						new Goal(
							new Predicate("print", new Term[] {
								new Variable(Type.STRING, "From"),
								new Variable(Type.STRING, "S")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {56,9,56,57},
			new MessageEvent(
				new Performative("refuse"),
				new Variable(Type.STRING, "From",false),
				new Predicate("state", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Manager", new int[] {56,56,61,5},
				new Statement[] {
					new ModuleCall("system",
						"Manager", new int[] {58,8,58,35},
						new Predicate("terminateAgent", new Term[] {
							new Variable(Type.STRING, "From")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Manager","system")).terminateAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("console",
						"Manager", new int[] {59,8,59,41},
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
								return ((astra.lang.Console) intention.getModule("Manager","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Manager", new int[] {60,8,61,5},
						new Goal(
							new Predicate("print", new Term[] {
								new Variable(Type.STRING, "From"),
								new Variable(Type.STRING, "S")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {63,9,63,58},
			new MessageEvent(
				new Performative("failure"),
				new Variable(Type.STRING, "From",false),
				new Predicate("state", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Manager", new int[] {63,57,67,5},
				new Statement[] {
					new ModuleCall("console",
						"Manager", new int[] {64,8,64,41},
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
								return ((astra.lang.Console) intention.getModule("Manager","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("system",
						"Manager", new int[] {65,8,65,35},
						new Predicate("terminateAgent", new Term[] {
							new Variable(Type.STRING, "From")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Manager","system")).terminateAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Manager", new int[] {66,8,67,5},
						new Goal(
							new Predicate("print", new Term[] {
								new Variable(Type.STRING, "From"),
								new Variable(Type.STRING, "S")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {69,9,69,91},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "From",false),
				new Predicate("done", new Term[] {
					new Variable(Type.STRING, "D",false)
				})
			),
			new OR(
				new Predicate("encryptor", new Term[] {
					new Variable(Type.STRING, "From")
				}),
				new Predicate("decryptor", new Term[] {
					new Variable(Type.STRING, "From")
				})
			),
			new Block(
				"Manager", new int[] {69,90,72,5},
				new Statement[] {
					new ModuleCall("system",
						"Manager", new int[] {70,8,70,35},
						new Predicate("terminateAgent", new Term[] {
							new Variable(Type.STRING, "From")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Manager","system")).terminateAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Manager", new int[] {71,8,72,5},
						new Goal(
							new Predicate("print", new Term[] {
								new Variable(Type.STRING, "From"),
								new Variable(Type.STRING, "D")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {74,9,74,88},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "Cracker",false),
				new Predicate("done", new Term[] {
					new Variable(Type.STRING, "P",false),
					new Variable(Type.STRING, "C",false)
				})
			),
			new Predicate("cracker", new Term[] {
				new Variable(Type.STRING, "Cracker")
			}),
			new Block(
				"Manager", new int[] {74,87,82,5},
				new Statement[] {
					new ModuleCall("system",
						"Manager", new int[] {75,8,75,38},
						new Predicate("terminateAgent", new Term[] {
							new Variable(Type.STRING, "Cracker")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Manager","system")).terminateAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Manager", new int[] {76,8,82,5},
						new Goal(
							new Predicate("print", new Term[] {
								new Variable(Type.STRING, "Cracker"),
								new Variable(Type.STRING, "P")
							})
						)
					),
					new ModuleCall("system",
						"Manager", new int[] {79,8,79,52},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("decryptor"),
							Primitive.newPrimitive("Decryptor")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Manager","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new Send("Manager", new int[] {81,8,81,53},
						new Performative("request"),
						Primitive.newPrimitive("decryptor"),
						new Predicate("taskDecrypt", new Term[] {
							new Variable(Type.STRING, "P"),
							new Variable(Type.STRING, "C")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {84,9,84,74},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "Cracker",false),
				new Predicate("done", new Term[] {
					new Variable(Type.INTEGER, "L",false)
				})
			),
			new Predicate("cracker", new Term[] {
				new Variable(Type.STRING, "Cracker")
			}),
			new Block(
				"Manager", new int[] {84,73,87,5},
				new Statement[] {
					new ModuleCall("console",
						"Manager", new int[] {85,8,85,62},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.STRING, "Cracker"),
								Operator.newOperator('+',
									Primitive.newPrimitive(" password length is: "),
									new Variable(Type.INTEGER, "L")
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Manager","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Manager", new int[] {86,8,87,5},
						new Goal(
							new Predicate("print", new Term[] {
								new Variable(Type.STRING, "Cracker"),
								new Variable(Type.INTEGER, "L")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {89,9,89,80},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "Cracker",false),
				new Predicate("problem", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			new Predicate("cracker", new Term[] {
				new Variable(Type.STRING, "Cracker")
			}),
			new Block(
				"Manager", new int[] {89,79,92,5},
				new Statement[] {
					new ModuleCall("system",
						"Manager", new int[] {90,8,90,38},
						new Predicate("terminateAgent", new Term[] {
							new Variable(Type.STRING, "Cracker")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Manager","system")).terminateAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Manager", new int[] {91,8,92,5},
						new Goal(
							new Predicate("print", new Term[] {
								new Variable(Type.STRING, "Cracker"),
								new Variable(Type.STRING, "S")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {94,9,94,78},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "Cracker",false),
				new Predicate("state", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			new Predicate("cracker", new Term[] {
				new Variable(Type.STRING, "Cracker")
			}),
			new Block(
				"Manager", new int[] {94,77,97,5},
				new Statement[] {
					new ModuleCall("console",
						"Manager", new int[] {95,8,95,63},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.STRING, "Cracker"),
								Operator.newOperator('+',
									Primitive.newPrimitive(" cracker inform state "),
									new Variable(Type.STRING, "S")
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Manager","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Manager", new int[] {96,8,97,5},
						new Goal(
							new Predicate("print", new Term[] {
								new Variable(Type.STRING, "Cracker"),
								new Variable(Type.STRING, "S")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {99,9,99,45},
			new GoalEvent('+',
				new Goal(
					new Predicate("print", new Term[] {
						new Variable(Type.STRING, "Where",false),
						new Variable(Type.STRING, "Text",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Manager", new int[] {99,44,101,5},
				new Statement[] {
					new ModuleCall("gui",
						"Manager", new int[] {100,8,100,35},
						new Predicate("sendString", new Term[] {
							new Variable(Type.STRING, "Where"),
							new Variable(Type.STRING, "Text")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((aop.GUIModule) intention.getModule("Manager","gui")).sendString(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Manager", new int[] {103,9,103,44},
			new GoalEvent('+',
				new Goal(
					new Predicate("print", new Term[] {
						new Variable(Type.STRING, "Where",false),
						new Variable(Type.INTEGER, "Number",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Manager", new int[] {103,43,105,5},
				new Statement[] {
					new ModuleCall("gui",
						"Manager", new int[] {104,8,104,34},
						new Predicate("sendInt", new Term[] {
							new Variable(Type.STRING, "Where"),
							new Variable(Type.INTEGER, "Number")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((aop.GUIModule) intention.getModule("Manager","gui")).sendInt(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Goal(
				new Predicate("init", new Term[] {})
			)
		);
		agent.initialize(
			new Predicate("cracker", new Term[] {
				Primitive.newPrimitive("cracker")
			})
		);
		agent.initialize(
			new Predicate("decryptor", new Term[] {
				Primitive.newPrimitive("decryptor")
			})
		);
		agent.initialize(
			new Predicate("encryptor", new Term[] {
				Primitive.newPrimitive("encryptor")
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("gui",aop.GUIModule.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
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
			astra.core.Agent agent = new Manager().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
