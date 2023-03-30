class CodeGen {
	int result;
	String geraCodigo(ArvoreSintatica arv) {
		return (geraCodigo2(arv) + "PRINT");
	}

	double geraResultado(ArvoreSintatica arv) {
		return geraResultado2(arv);
	}

	String geraCodigo2(ArvoreSintatica arv) {
		if (arv instanceof Mult) {
			return (geraCodigo2(((Mult) arv).arg1) +
					geraCodigo2(((Mult) arv).arg2) +
					"MULT\n");
		}

		if (arv instanceof Soma) {
			return (geraCodigo2(((Soma) arv).arg1) +
					geraCodigo2(((Soma) arv).arg2) +
					"SUM\n");
		}

		if (arv instanceof Sub)
			return (geraCodigo2(((Sub) arv).arg1) +
					geraCodigo2(((Sub) arv).arg2) +
					"SUB\n");

		if (arv instanceof Div)
			return (geraCodigo2(((Div) arv).arg1) +
					geraCodigo2(((Div) arv).arg2) +
					"DIV\n");

		if (arv instanceof Num)
			return ("PUSH " + ((Num) arv).num + "\n");

		return "";
	}


	double geraResultado2(ArvoreSintatica arv) {
		if (arv instanceof Mult) {
			return (double)(geraResultado2(((Mult) arv).arg1) *
			geraResultado2(((Mult) arv).arg2));
		}

		if (arv instanceof Soma) {
			return (double)(geraResultado2(((Soma) arv).arg1) +
			geraResultado2(((Soma) arv).arg2));
		}

		if (arv instanceof Sub)
			return (double)(geraResultado2(((Sub) arv).arg1) -
			geraResultado2(((Sub) arv).arg2));

		if (arv instanceof Div)
			return (double)(geraResultado2(((Div) arv).arg1) /
			geraResultado2(((Div) arv).arg2));

		if (arv instanceof Num)
			return (double)((Num) arv).num;

		return 0.0;
	}
}
