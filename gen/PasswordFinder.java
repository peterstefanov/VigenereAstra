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


public class PasswordFinder extends ASTRAClass {
	public PasswordFinder() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"PasswordFinder", new int[] {16,9,16,93},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "Cracker",false),
				new Predicate("taskPassword", new Term[] {
					new Variable(Type.STRING, "C",false),
					new Variable(Type.INTEGER, "L",false)
				})
			),
			new Predicate("cracker", new Term[] {
				new Variable(Type.STRING, "Cracker")
			}),
			new Block(
				"PasswordFinder", new int[] {16,92,29,5},
				new Statement[] {
					new If(
						"PasswordFinder", new int[] {18,9,29,5},
						new OR(
							new Comparison("==",
								new Variable(Type.STRING, "C"),
								Primitive.newPrimitive("")
							),
							new Comparison("==",
								new Variable(Type.INTEGER, "L"),
								Primitive.newPrimitive(0)
							)
						),
						new Block(
							"PasswordFinder", new int[] {18,29,20,10},
							new Statement[] {
								new Send("PasswordFinder", new int[] {19,12,19,85},
									new Performative("refuse"),
									new Variable(Type.STRING, "Cracker"),
									new Predicate("state", new Term[] {
										Operator.newOperator('+',
											new ModuleTerm("system", Type.STRING,
												new Predicate("name", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("PasswordFinder","system")).name(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.System) visitor.agent().getModule("PasswordFinder","system")).name(
														);
													}
												}
											),
											Primitive.newPrimitive(" refused to find password")
										)
									})
								)
							}
						),
						new Block(
							"PasswordFinder", new int[] {20,16,29,5},
							new Statement[] {
								new Send("PasswordFinder", new int[] {21,12,21,83},
									new Performative("agree"),
									new Variable(Type.STRING, "Cracker"),
									new Predicate("state", new Term[] {
										Operator.newOperator('+',
											new ModuleTerm("system", Type.STRING,
												new Predicate("name", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("PasswordFinder","system")).name(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.System) visitor.agent().getModule("PasswordFinder","system")).name(
														);
													}
												}
											),
											Primitive.newPrimitive(" agreed to find password")
										)
									})
								),
								new TryRecover(
									"PasswordFinder", new int[] {23,12,28,9},
									new Block(
										"PasswordFinder", new int[] {23,16,25,13},
										new Statement[] {
											new Subgoal(
												"PasswordFinder", new int[] {24,17,25,13},
												new Goal(
													new Predicate("doPassword", new Term[] {
														new Variable(Type.STRING, "C"),
														new Variable(Type.INTEGER, "L")
													})
												)
											)
										}
									),
									new Block(
										"PasswordFinder", new int[] {25,22,28,9},
										new Statement[] {
											new Send("PasswordFinder", new int[] {26,16,26,88},
												new Performative("failure"),
												new Variable(Type.STRING, "Cracker"),
												new Predicate("state", new Term[] {
													Operator.newOperator('+',
														new ModuleTerm("system", Type.STRING,
															new Predicate("name", new Term[] {}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((astra.lang.System) intention.getModule("PasswordFinder","system")).name(
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((astra.lang.System) visitor.agent().getModule("PasswordFinder","system")).name(
																	);
																}
															}
														),
														Primitive.newPrimitive(" fails to find password")
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
			"PasswordFinder", new int[] {31,9,31,67},
			new GoalEvent('+',
				new Goal(
					new Predicate("doPassword", new Term[] {
						new Variable(Type.STRING, "C",false),
						new Variable(Type.INTEGER, "PL",false)
					})
				)
			),
			new Predicate("cracker", new Term[] {
				new Variable(Type.STRING, "Cracker",false)
			}),
			new Block(
				"PasswordFinder", new int[] {31,66,38,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "password"),
						"PasswordFinder", new int[] {32,8,38,5},
						new ModuleTerm("vig", Type.STRING,
							new Predicate("getPassword", new Term[] {
								new Variable(Type.STRING, "C"),
								new Variable(Type.INTEGER, "PL")
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((aop.Vigenere) intention.getModule("PasswordFinder","vig")).getPassword(
										(java.lang.String) intention.evaluate(predicate.getTerm(0)),
										(java.lang.Integer) intention.evaluate(predicate.getTerm(1))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((aop.Vigenere) visitor.agent().getModule("PasswordFinder","vig")).getPassword(
										(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
										(java.lang.Integer) visitor.evaluate(predicate.getTerm(1))
									);
								}
							}
						)
					),
					new If(
						"PasswordFinder", new int[] {33,8,38,5},
						new Comparison("==",
							new Variable(Type.STRING, "password"),
							Primitive.newPrimitive("")
						),
						new Block(
							"PasswordFinder", new int[] {33,27,35,10},
							new Statement[] {
								new ModuleCall("system",
									"PasswordFinder", new int[] {34,12,34,25},
									new Predicate("fail", new Term[] {}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("PasswordFinder","system")).fail(
											);
										}
									}
								)
							}
						),
						new Block(
							"PasswordFinder", new int[] {35,16,38,5},
							new Statement[] {
								new Send("PasswordFinder", new int[] {36,12,36,52},
									new Performative("inform"),
									new Variable(Type.STRING, "Cracker"),
									new Predicate("done", new Term[] {
										new Variable(Type.STRING, "password"),
										new Variable(Type.STRING, "C")
									})
								)
							}
						)
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
		fragment.addModule("vig",aop.Vigenere.class,agent);
		fragment.addModule("support",aop.utils.Support.class,agent);
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
			astra.core.Agent agent = new PasswordFinder().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
